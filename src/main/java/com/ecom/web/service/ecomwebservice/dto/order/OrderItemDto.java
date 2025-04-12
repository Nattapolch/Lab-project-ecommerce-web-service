package com.ecom.web.service.ecomwebservice.dto.order;

import lombok.Data;

@Data
public class OrderItemDto {
    private Integer id;
    private String name;
    private double price;
    private Integer quantity;
    private double total_price;
}
