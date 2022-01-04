package com.group1.energymanager.request;

public class RegistrationRequest {
    private String ragSociale;
    private String username;
    private String password;
    private Float wallet;

    public RegistrationRequest(String ragSociale, String username, String password, Float wallet) {
        this.ragSociale = ragSociale;
        this.username = username;
        this.password = password;
        this.wallet = wallet;
    }

    public String getRagSociale() {
        return ragSociale;
    }

    public void setRagSociale(String ragSociale) {
        this.ragSociale = ragSociale;
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

    public Float getWallet() {
        return wallet;
    }

    public void setWallet(Float wallet) {
        this.wallet = wallet;
    }
}

