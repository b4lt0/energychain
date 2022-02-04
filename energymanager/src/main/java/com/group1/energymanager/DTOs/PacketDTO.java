package com.group1.energymanager.DTOs;
import com.group1.energymanager.model.Packet;
import com.group1.energymanager.model.Type;
import com.group1.energymanager.model.User;
public class PacketDTO {
    //private BaseResponse result;
    private String id;
    private User userId;
    private String title;
    private String description;
    private Long quantity;
    private Double price;
    private Type type;

    public PacketDTO(String packetID) {
        this.id=packetID;
    }

    public PacketDTO() { }

    public PacketDTO(String id, User userId,String title, String description, Long quantity, Double price, Type type) {
        this.id = id;
        this.userId = userId;
        this.title = title;
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
}