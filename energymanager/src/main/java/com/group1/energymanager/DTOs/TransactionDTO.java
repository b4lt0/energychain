package com.group1.energymanager.DTOs;

import com.group1.energymanager.model.Packet;
import com.group1.energymanager.model.User;

import java.sql.Timestamp;

public class TransactionDTO {
        private String transactionID;
        private User sellerId;
        private User buyerId;
        private Packet packetId;
        private Timestamp time;

        public TransactionDTO(String transactionID) {
            this.transactionID = transactionID;
        }

        public TransactionDTO() {
        }

        public TransactionDTO(String TransactionID, User sellerId, User buyerID, Packet packetID, Timestamp time){
            this.transactionID = transactionID;
            this.sellerId= sellerId;
            this.buyerId = buyerID;
            this.packetId = packetID;
            this.time = time;
        }

        public String getTransactionID() {
            return transactionID;
        }

        public void setTransactionID(String transactionID) {
            this.transactionID = transactionID;
        }

        public User getSellerId() {
            return sellerId;
        }

        public void setSellerId(User sellerId) {
            this.sellerId = sellerId;
        }

        public User getBuyerId() {
            return buyerId;
        }

        public void setBuyerId(User buyerId) {
            this.buyerId = buyerId;
        }

        public Packet getPacketId() {
            return packetId;
        }

        public void setPacketId(Packet packetId) {
            this.packetId = packetId;
        }

        public Timestamp getTime() {
            return time;
        }

        public void setTime(Timestamp time) {
            this.time = time;
        }
    }


