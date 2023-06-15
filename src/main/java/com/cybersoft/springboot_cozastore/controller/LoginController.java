package com.cybersoft.springboot_cozastore.controller;

import com.cybersoft.springboot_cozastore.jwt.JwtHelper;
import com.cybersoft.springboot_cozastore.payload.request.SigninRequest;
import com.cybersoft.springboot_cozastore.payload.request.SignupRequest;
import com.cybersoft.springboot_cozastore.payload.response.BaseResponse;
import com.cybersoft.springboot_cozastore.service.LoginService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtHelper jwtHelper;
    @RequestMapping(value = "/signin",method = RequestMethod.POST )
    public ResponseEntity<?> sigin(@Valid @RequestBody SigninRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        // if success:
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Success");
        response.setData(jwtHelper.generateToken(request.getEmail()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public ResponseEntity<?> signup (@Valid @RequestBody SignupRequest request){
        boolean signupIsSuccess = loginService.sigup(request);
        BaseResponse baseResponse = new BaseResponse();
        if(signupIsSuccess){
                baseResponse.setData(jwtHelper.generateToken(request.getEmailAddress()));
                baseResponse.setStatusCode(200);
                baseResponse.setMessage("Signup is success !");
        }

        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }
}
