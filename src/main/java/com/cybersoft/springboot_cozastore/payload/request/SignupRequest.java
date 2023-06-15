package com.cybersoft.springboot_cozastore.payload.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SignupRequest {
    @NotEmpty(message = "Email is not null!")
    @NotEmpty(message = "Email is not empty!")
    @Email(message = "Email is invalid")
    private String emailAddress;
    @NotEmpty(message = "Username is not empty!")
    @NotNull(message = "Username is not null!")
    @Length(min = 4,message = "Username must have at least 4 characters!")
    private String username ;
    @NotEmpty(message = "Password is not empty!")
    @Length(min = 6,message = "Password must have at least 6 characters!")
    private String password ;

    public SignupRequest() {
    }

    public SignupRequest(String emailAddress, String username, String password) {
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
