package com.group1.energymanager.response;
import com.group1.energymanager.DTOs.PacketDTO;

public class PacketResponse {
    private BaseResponse result;
    private PacketDTO packet;

    public PacketResponse(){
        this.result=new BaseResponse();
        this.packet=new PacketDTO();
    }

    public BaseResponse getResult() {
        return result;
    }

    public void setResult(BaseResponse result) {
        this.result = result;
    }

    public PacketDTO getPacket() {
        return packet;
    }

    public void setPacket(PacketDTO packet) {
        this.packet = packet;
    }
}