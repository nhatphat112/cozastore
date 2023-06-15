package com.cybersoft.springboot_cozastore.payload.response;

public class BaseResponse {
    private int statusCode;
    private String message;
    private String data;

    public BaseResponse() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BaseResponse(int statusCode, String message, String data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
}
