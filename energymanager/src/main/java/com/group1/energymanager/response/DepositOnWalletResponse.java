package com.group1.energymanager.response;

public class DepositOnWalletResponse {

    private BaseResponse result;
    private String id;
    private float wallet;

    public BaseResponse getResult() {
        return result;
    }

    public void setResult(BaseResponse result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }
}
