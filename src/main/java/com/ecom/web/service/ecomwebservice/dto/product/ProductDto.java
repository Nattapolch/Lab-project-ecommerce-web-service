package com.ecom.web.service.ecomwebservice.dto.product;

import java.util.Date;

import lombok.Data;

@Data
public class ProductDto {

    private Integer id;
    private String name;
    private String image;
    private String shortDetail;
    private double price;
    private Date updateDate;
}
