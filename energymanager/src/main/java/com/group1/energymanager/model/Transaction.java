package com.group1.energymanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.group1.energymanager.DTOs.TransactionDTO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Optional;

@Entity
@Table(name="transaction")
public class Transaction implements Serializable {

//     public TransactionDTO toDTO;

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="transaction_id", nullable = false, updatable = false)
    private String id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seller_id", nullable = false)
    @JsonBackReference
    private User sellerId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "buyer_id", nullable = false)
    @JsonBackReference
    private User buyerId;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "packet_id", nullable = false)
    @JsonBackReference
    private Packet packetId;

    private Timestamp time;

    public Transaction() {
    }

    public Transaction(String id, User sellerId, User buyerId, Packet packetId) {
        this.id = id;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.packetId = packetId;
        this.time = new Timestamp(System.currentTimeMillis());
    }
    public TransactionDTO toDTO() {
        final TransactionDTO transactionDTO = new TransactionDTO(this.id, this.sellerId, this.buyerId, this.packetId, this.time);
        return transactionDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public TransactionDTO toDTO() {
        return new TransactionDTO(this.id, this.sellerId, this.buyerId, this.packetId, this.time);
    }
}
