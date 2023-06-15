package com.cybersoft.springboot_cozastore.service;

import com.cybersoft.springboot_cozastore.entity.UserEntity;
import com.cybersoft.springboot_cozastore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService implements UserServiceImp{
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
