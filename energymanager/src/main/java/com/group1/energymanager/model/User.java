package com.group1.energymanager.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id", nullable = false, updatable = false)
    private String id;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Packet> packets = new ArrayList<Packet>();

    @OneToMany(mappedBy = "sellerId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Transaction> sell_transactions = new ArrayList<Transaction>();;
    @OneToMany(mappedBy = "buyerId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Transaction> buy_transactions = new ArrayList<Transaction>();;

    private String ragSociale;
    private String username;
    private String password;
    private Float wallet;

    public User(){ }

    public User(String id, List<Packet> packets, List<Transaction> sell_transactions, List<Transaction> buy_transactions, String ragSociale, String username, String password, Float wallet) {
        this.id = id;
        this.packets = packets;
        this.sell_transactions = sell_transactions;
        this.buy_transactions = buy_transactions;
        this.ragSociale = ragSociale;
        this.username = username;
        this.password = password;
        this.wallet = wallet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Packet> getPackets() {
        return packets;
    }

    public void setPackets(List<Packet> packets) {
        this.packets = packets;
    }

    public List<Transaction> getSell_transactions() {
        return sell_transactions;
    }

    public void setSell_transactions(List<Transaction> sell_transactions) {
        this.sell_transactions = sell_transactions;
    }

    public List<Transaction> getBuy_transactions() {
        return buy_transactions;
    }

    public void setBuy_transactions(List<Transaction> buy_transactions) {
        this.buy_transactions = buy_transactions;
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
