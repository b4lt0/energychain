package com.group1.energymanager.request;

import java.sql.Timestamp;

public class TransactionRequest {
    private String id;

    private String sellerId;

    private String buyerId;

    private String packetId;

    private Timestamp time; //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

    public TransactionRequest(String id, String sellerId, String buyerId, String packetId) {
        this.id = id;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.packetId = packetId;
        //this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getPacketId() {
        return packetId;
    }

    public void setPacketId(String packetId) {
        this.packetId = packetId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}