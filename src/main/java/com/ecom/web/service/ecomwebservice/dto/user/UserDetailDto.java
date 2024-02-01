package com.ecom.web.service.ecomwebservice.dto.user;

import lombok.Data;

@Data
public class UserDetailDto {
    private Integer id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private Integer role;
    private Boolean isActive;
}
