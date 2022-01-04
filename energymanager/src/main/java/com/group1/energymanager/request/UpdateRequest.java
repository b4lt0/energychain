package com.group1.energymanager.request;

public class UpdateRequest {
    private String userID;
    private String ragSociale;
    private String username;
    private String password;


    public UpdateRequest(String userID, String ragSociale, String username, String password) {
        this.ragSociale = ragSociale;
        this.username = username;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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
}
