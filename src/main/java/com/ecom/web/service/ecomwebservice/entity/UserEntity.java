package com.ecom.web.service.ecomwebservice.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Integer id;

    @Column(name="Username")
    private String username;

    @Column(name="Password")
    private String password;

    @Column(name="Name")
    private String name;

    @Column(name="Surname")
    private String surname;

    @Column(name="Email")
    private String email;

    @Column(name="Role")
    private Integer role;

    @Column(name="Is_Active")
    private Integer isActive;

    @Column(name="Create_Date")
    private Date createDate;

    @Column(name="Update_Date")
    private Date updateDate;
}
