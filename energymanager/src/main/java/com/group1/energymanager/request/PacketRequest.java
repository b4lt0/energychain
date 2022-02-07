package com.group1.energymanager.request;
import com.group1.energymanager.model.Type;

public class PacketRequest {
    private String id;
    private String owner;
    private String title;
    private String description;
    private Long quantity;
    private Double price;
    private Type type;

    public PacketRequest(String id, String owner, String title, String description, Long quantity, Double price, Type type) {
        this.id = id;
        this.owner = owner;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    public PacketRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
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
}
