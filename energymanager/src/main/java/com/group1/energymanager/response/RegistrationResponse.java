package com.group1.energymanager.response;

public class RegistrationResponse{
    private BaseResponse result;
    private String userID;

    public BaseResponse getResult() {
        return result;
    }

    public void setResult(BaseResponse result) {
        this.result = result;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
