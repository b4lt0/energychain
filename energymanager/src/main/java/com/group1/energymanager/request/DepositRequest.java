package com.group1.energymanager.request;

public class DepositRequest {
    private String id;
    private Double wallet;

    public DepositRequest(String id, Double wallet) {
        this.id = id;
        this.wallet = wallet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet) {
        this.wallet = wallet;
    }
}
