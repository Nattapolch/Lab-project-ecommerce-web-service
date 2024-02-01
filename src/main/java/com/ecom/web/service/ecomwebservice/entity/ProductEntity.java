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
@Table(name="products")
public class ProductEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Integer id;

    @Column(name="Name")
    private String name;

    @Column(name="Detail")
    private String detail;

    @Column(name="Short_Detail")
    private String shortDetail;

    @Column(name="Price")
    private double price;

    @Column(name="Category")
    private Integer category;

    @Column(name="Image")
    private String image;

    @Column(name="Quantity")
    private Integer quantity;

    @Column(name="Create_Date")
    private Date createDate;

    @Column(name="Update_Date")
    private Date updateDate;
}
