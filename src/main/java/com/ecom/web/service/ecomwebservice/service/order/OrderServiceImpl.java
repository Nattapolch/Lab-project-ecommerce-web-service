package com.ecom.web.service.ecomwebservice.service.order;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.web.service.ecomwebservice.dto.ResponseBase;
import com.ecom.web.service.ecomwebservice.dto.order.OrderItemDto;
import com.ecom.web.service.ecomwebservice.dto.order.OrderRequestDto;
import com.ecom.web.service.ecomwebservice.dto.order.OrderResponseDto;
import com.ecom.web.service.ecomwebservice.entity.OrderEntity;
import com.ecom.web.service.ecomwebservice.entity.ProductEntity;
import com.ecom.web.service.ecomwebservice.repository.OrderRepository;
import com.ecom.web.service.ecomwebservice.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    
    @Autowired
    ProductRepository productRepository;
    
    private ObjectMapper objectMapper = new ObjectMapper();
    
    @Override
    @Transactional
    public ResponseBase<OrderResponseDto> CreateOrder(OrderRequestDto request) {
        var response = new ResponseBase<OrderResponseDto>();
        
        try {
            
            String orderDetailJson = objectMapper.writeValueAsString(request.getItems());
            
            
            double totalPrice = request.getItems().stream()
                    .mapToDouble(item -> item.getTotal_price())
                    .sum();
            
            
            OrderEntity order = new OrderEntity();
            order.setOrderDetail(orderDetailJson);
            order.setTotalPrice(totalPrice);
            order.setOrderBy(request.getOrderBy());
            
            
            Timestamp currentTimestamp = Timestamp.valueOf(LocalDateTime.now());
            order.setCreateDate(currentTimestamp);
            order.setUpdateDate(currentTimestamp);
            
            
            OrderEntity savedOrder = orderRepository.save(order);
            
            
            List<OrderItemDto> items = request.getItems();
            for (int i = 0; i < items.size(); i++) {
                OrderItemDto item = items.get(i);
                updateProductQuantity(item.getId(), item.getQuantity());
            }
            
            OrderResponseDto responseDto = new OrderResponseDto();
            responseDto.setId(savedOrder.getId());
            responseDto.setOrderDetail(savedOrder.getOrderDetail());
            responseDto.setTotalPrice(savedOrder.getTotalPrice());
            responseDto.setOrderBy(savedOrder.getOrderBy());
            responseDto.setCreateDate(savedOrder.getCreateDate());
            
            response.setData(responseDto);
            response.setErrorCode("0000");
            response.setErrorMessage("success");
            
        } catch (JsonProcessingException ex) {
            response.setErrorCode("OS0001");
            response.setErrorMessage("Error processing order: " + ex.getMessage());
        } catch (Exception ex) {
            response.setErrorCode("9999");
            response.setErrorMessage("Exception was occurred: " + ex.getMessage());
        }
        
        return response;
    }
    

    private void updateProductQuantity(Integer productId, Integer quantityToReduce) {
        Optional<ProductEntity> productOpt = productRepository.findById(productId);
        
        if (productOpt.isPresent()) {
            ProductEntity product = productOpt.get();
            Integer currentQuantity = product.getQuantity();
            

            Integer newQuantity = currentQuantity - quantityToReduce;
            

            if (newQuantity < 0) {
                newQuantity = 0;
            }
            
            product.setQuantity(newQuantity);
            

            Timestamp currentTimestamp = Timestamp.valueOf(LocalDateTime.now());
            product.setUpdateDate(currentTimestamp);
            

            productRepository.save(product);
        }
    }
}