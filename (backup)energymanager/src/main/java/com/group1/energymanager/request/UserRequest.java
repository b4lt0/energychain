package com.group1.energymanager.request;

import com.group1.energymanager.model.Packet;
import com.group1.energymanager.model.Transaction;

import java.util.List;

public class UserRequest {
    private String id;
    private String ragSociale;
    private String username;

    public UserRequest(String id, String ragSociale, String username) {
        this.id = id;
        this.ragSociale = ragSociale;
        this.username = username;
    }

    public UserRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

}

