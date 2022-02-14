package com.group1.energymanager.request;
import com.group1.energymanager.model.Type;

public class PacketRequest {
    private String id;
    private String userId;
    private String description;
    private Integer quantity;
    private Integer price;
    private Type type;

    public PacketRequest(String id, String userId, String description, Integer quantity, Integer price, Type type) {
        this.id = id;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUser(String userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
