package com.ecom.web.service.ecomwebservice.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Integer id;
    
    @Column(name="Order_Detail", columnDefinition = "varchar(MAX)")
    private String orderDetail;
    
    @Column(name="Total_Price")
    private double totalPrice;
    
    @Column(name="Order_By")
    private Integer orderBy;
    
    @Column(name="Create_Date")
    private Timestamp createDate;
    
    @Column(name="Update_Date")
    private Timestamp updateDate;
}
