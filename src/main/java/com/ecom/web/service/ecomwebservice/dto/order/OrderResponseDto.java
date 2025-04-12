package com.ecom.web.service.ecomwebservice.dto.order;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Integer id;
    private String orderDetail;
    private double totalPrice;
    private Integer orderBy;
    private Timestamp createDate;
} 