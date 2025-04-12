package com.ecom.web.service.ecomwebservice.dto.order;

import java.util.List;
import lombok.Data;

@Data
public class OrderRequestDto {
    private List<OrderItemDto> items;
    private Integer orderBy;
}
