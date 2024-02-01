package com.ecom.web.service.ecomwebservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.web.service.ecomwebservice.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer>{
    
    List<ProductEntity> findTop5ByOrderByUpdateDateDesc();
}
