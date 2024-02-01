package com.ecom.web.service.ecomwebservice.service.product;

import java.util.List;

import com.ecom.web.service.ecomwebservice.dto.ResponseBase;
import com.ecom.web.service.ecomwebservice.dto.product.ProductDto;

public interface ProductService {
    
    ResponseBase<List<ProductDto>> GetNewArrivalProduct();
}
