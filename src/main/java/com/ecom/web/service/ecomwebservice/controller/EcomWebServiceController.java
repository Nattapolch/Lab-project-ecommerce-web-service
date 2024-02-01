package com.ecom.web.service.ecomwebservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ecom.web.service.ecomwebservice.dto.ResponseBase;
import com.ecom.web.service.ecomwebservice.dto.product.ProductDto;
import com.ecom.web.service.ecomwebservice.dto.user.UserDetailDto;
import com.ecom.web.service.ecomwebservice.dto.user.UserDetailRequest;
import com.ecom.web.service.ecomwebservice.service.product.ProductService;
import com.ecom.web.service.ecomwebservice.service.user.UserService;
import com.ecom.web.service.ecomwebservice.service.webDetail.WebDetailService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/ecom/web-service")
@CrossOrigin(origins = {"null"})
public class EcomWebServiceController {
    
    @Autowired
    WebDetailService webDetailService;
    
    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @GetMapping("/version")
    public ResponseEntity<ResponseBase<String>> ServiceVertion() {
        
        var response = webDetailService.GetVersion();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/user/detail")
    public ResponseEntity<ResponseBase<UserDetailDto>> GetUserDetail(@RequestBody UserDetailRequest request) {

        var response = userService.GetUserDetail(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/newArrival")
    public ResponseEntity<ResponseBase<List<ProductDto>>> GetNewArrivalProduct() {

        var response = productService.GetNewArrivalProduct();
        return ResponseEntity.ok(response);
    }
}
