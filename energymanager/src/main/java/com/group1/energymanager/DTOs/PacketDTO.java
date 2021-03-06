package com.group1.energymanager.DTOs;
import com.group1.energymanager.model.Type;
import com.group1.energymanager.model.User;
public class PacketDTO {
    //private BaseResponse result;
    private String id;
    private User userId;
    private String description;
    private Integer quantity;
    private Integer price;
    private Type type;

    public PacketDTO(String packetID) {
        this.id=packetID;
    }

    public PacketDTO() { }

    public PacketDTO(String id, User userId, String description, Integer quantity, Integer price, Type type) {
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    /* public BaseResponse getResult() {
             return result;
         }
         public void setResult(BaseResponse result) {
             this.result = result;
         }
         */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
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