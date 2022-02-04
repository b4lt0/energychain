package com.group1.energymanager.request;
import com.group1.energymanager.model.Type;
import com.group1.energymanager.model.User;

public class PacketRequest {
    private String id;
    private String userId;
    private String title;
    private String description;
    private Long quantity;
    private Double price;
    private Type type;

    public PacketRequest(String id, String userId,String title, String description, Long quantity, Double price, Type type) {
        this.id = id;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUser(String userId) {
        this.userId = userId;
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
