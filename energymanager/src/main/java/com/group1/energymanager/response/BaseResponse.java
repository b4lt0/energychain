package com.group1.energymanager.response;

import org.springframework.http.HttpStatus;

public class BaseResponse {
    private HttpStatus status;
    private String msg;

    public BaseResponse() {
    }

    public BaseResponse(HttpStatus status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
