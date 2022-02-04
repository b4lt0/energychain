package com.group1.energymanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group1.energymanager.DTOs.PacketDTO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="packet")
public class Packet implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "packet_id", nullable = false, updatable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "packetId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Transaction> transactions = new ArrayList<Transaction>();

    private String title;
    private String description;
    private Long quantity;
    private Double price;
    private Type type;

    public Packet() {
    }

    public Packet(String id) {
        this.id = id;
    }

    public Packet(String id, User user, List<Transaction> transactions,String title,  String description, Long quantity, Double price, Type type) {
        this.id = id;
        this.user = user;
        this.transactions = transactions;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    public PacketDTO toDTO() {
        final PacketDTO packetDTO = new PacketDTO(this.id, this.user, this.title, this.description,
                this.quantity, this.price, this.type);
        return packetDTO;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Packet)) return false;
        Packet packet = (Packet) o;
        return getId().equals(packet.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

