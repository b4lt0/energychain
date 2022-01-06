package com.group1.energymanager.request;

public class RegistrationRequest {
    private String ragSociale;
    private String username;
    private String password;
    private Double wallet;

    public RegistrationRequest(String ragSociale, String username, String password, Double wallet) {
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

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet) {
        this.wallet = wallet;
    }
}