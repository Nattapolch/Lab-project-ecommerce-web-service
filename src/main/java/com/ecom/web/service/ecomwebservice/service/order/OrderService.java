package com.ecom.web.service.ecomwebservice.service.order;

import com.ecom.web.service.ecomwebservice.dto.ResponseBase;
import com.ecom.web.service.ecomwebservice.dto.order.OrderRequestDto;
import com.ecom.web.service.ecomwebservice.dto.order.OrderResponseDto;

public interface OrderService {
ResponseBase<OrderResponseDto> CreateOrder(OrderRequestDto request);
    
}