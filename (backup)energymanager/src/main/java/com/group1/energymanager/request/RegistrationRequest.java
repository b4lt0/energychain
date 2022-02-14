package com.group1.energymanager.request;

public class RegistrationRequest {
    private String username;
    private String password;
    private String ragSociale;
    private Double wallet;

    public RegistrationRequest(String username, String password, String ragSociale, Double wallet) {
        this.username = username;
        this.password = password;
        this.ragSociale = ragSociale;
        this.wallet = wallet;
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

    public String getRagSociale() {
        return ragSociale;
    }

    public void setRagSociale(String ragSociale) {
        this.ragSociale = ragSociale;
    }

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet) {
        this.wallet = wallet;
    }
}
