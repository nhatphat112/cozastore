package com.cybersoft.springboot_cozastore.provider;

import com.cybersoft.springboot_cozastore.entity.UserEntity;
import com.cybersoft.springboot_cozastore.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomAuthenticatonProvider implements AuthenticationProvider {
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserServiceImp userServiceImp;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserEntity userEntity =userServiceImp.findByEmail(username);
        System.out.println("Check userEntity:"+userEntity);
        if(userEntity!=null&& passwordEncoder.matches(password,userEntity.getPassword())){

            return new UsernamePasswordAuthenticationToken(username,password,new ArrayList<>());
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
