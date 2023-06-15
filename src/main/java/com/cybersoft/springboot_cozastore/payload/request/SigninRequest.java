package com.cybersoft.springboot_cozastore.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SigninRequest {
    @NotNull(message = "Email is not null!")
    @NotEmpty(message = "Email is not empty!")
    @Email(message = "Email is invalid!")
    private String email;
    @NotNull(message = "Password is not null!")
    @NotEmpty(message = "Password is not empty!")

    private String password;

    public SigninRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public SigninRequest() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
