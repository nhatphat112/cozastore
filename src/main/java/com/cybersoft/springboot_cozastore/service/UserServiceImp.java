package com.cybersoft.springboot_cozastore.service;

import com.cybersoft.springboot_cozastore.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceImp {
    UserEntity findByEmail(String email);
}
