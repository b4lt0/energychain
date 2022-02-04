package com.group1.energymanager.response;

import com.group1.energymanager.DTOs.PacketDTO;
import com.group1.energymanager.model.Packet;

import java.util.List;

public class ListPacketResponse {
    private BaseResponse result;
    private List<Packet> listPacket;

    public BaseResponse getResult() {
        return result;
    }

    public void setResult(BaseResponse result) {
        this.result = result;
    }

    public List<Packet> getListPacket() {
        return listPacket;
    }

    public void setListPacket(List<Packet> listPacket) {
        this.listPacket = listPacket;
    }
}
