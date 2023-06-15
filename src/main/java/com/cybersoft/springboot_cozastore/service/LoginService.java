package com.cybersoft.springboot_cozastore.service;

import com.cybersoft.springboot_cozastore.entity.UserEntity;
import com.cybersoft.springboot_cozastore.payload.request.SignupRequest;
import com.cybersoft.springboot_cozastore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public boolean sigup(SignupRequest request){
        boolean signupIsSuccess = false;
        UserEntity userEntity = userRepository.findByEmail(request.getEmailAddress());
        if(userEntity==null){
            UserEntity user= new UserEntity();
            user.setEmail(request.getEmailAddress());
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            userRepository.save(user);
            signupIsSuccess=true;
        }
        return signupIsSuccess;

    }

}
