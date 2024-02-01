package com.ecom.web.service.ecomwebservice.service.product;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.web.service.ecomwebservice.dto.ResponseBase;
import com.ecom.web.service.ecomwebservice.dto.product.ProductDto;
import com.ecom.web.service.ecomwebservice.entity.ProductEntity;
import com.ecom.web.service.ecomwebservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    ProductRepository productRepository;

    ModelMapper modelMapper = new ModelMapper();

    public ResponseBase<List<ProductDto>> GetNewArrivalProduct(){

        var response = new ResponseBase<List<ProductDto>>();
        List<ProductDto> data = new ArrayList<>();

        try{

            var result = productRepository.findTop5ByOrderByUpdateDateDesc();

            if(result == null){
                response.setErrorCode("PS0001");
                response.setErrorMessage("Cannot get new arrival product.");

                return response;
            }

            for(ProductEntity product : result){
                
                var productDetail = modelMapper.map(product, ProductDto.class);
                data.add(productDetail);
            }

            response.setData(data);
            response.setErrorCode("0000");
            response.setErrorMessage("success");

            return response;

        }
        catch(Exception ex){
            response.setErrorCode("9999");
            response.setErrorMessage("Exception was occured : " + ex.getMessage());

            return response;
        }
        
    }
}
