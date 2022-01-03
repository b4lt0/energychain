package com.group1.energymanager.DTOs;

import com.group1.energymanager.model.Packet;
import com.group1.energymanager.model.User;

import java.sql.Timestamp;

public class TransactionDTO {
        private String transactionID;
        private String sellerId;
        private String buyerId;
        private String packetId;
        private Timestamp time;

        public TransactionDTO(String transactionID) {
            this.transactionID = transactionID;
        }

        public TransactionDTO() {
        }

    public TransactionDTO(String transactionID, String sellerId, String buyerId, String packetId, Timestamp time) {
        this.transactionID = transactionID;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.packetId = packetId;
        this.time = time;
    }

    public TransactionDTO(String TransactionID, User sellerId, User buyerID, Packet packetID, Timestamp time){
            this.transactionID = transactionID;
            this.sellerId= sellerId.getId();
            this.buyerId = buyerID.getId();
            this.packetId = packetID.getId();
            this.time = time;
        }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
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


