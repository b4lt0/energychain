package com.group1.energymanager.response;

import org.springframework.http.HttpStatus;

public class BaseResponse {
    private HttpStatus status;
    private String errorMsg;

    public BaseResponse(HttpStatus status, String errorMsg) {
        this.status = status;
        this.errorMsg = errorMsg;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
