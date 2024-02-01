package com.ecom.web.service.ecomwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.web.service.ecomwebservice.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer>{
    UserEntity findByUsernameAndPassword(String username, String password);
}
