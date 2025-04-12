package com.ecom.web.service.ecomwebservice.service.product;

import java.util.List;

import com.ecom.web.service.ecomwebservice.dto.ResponseBase;
import com.ecom.web.service.ecomwebservice.dto.product.ProductDto;
import com.ecom.web.service.ecomwebservice.entity.ProductEntity;

public interface ProductService {
    
    ResponseBase<List<ProductDto>> GetNewArrivalProduct();
    ResponseBase<ProductEntity> GetProductDetail(Integer id);
}
