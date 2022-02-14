package com.group1.energymanager.response;

import com.group1.energymanager.DTOs.PacketDTO;

import java.util.List;

public class ListPacketResponse {
    private BaseResponse result;
    private List<PacketDTO> listPacketDTO;

    public BaseResponse getResult() {
        return result;
    }

    public void setResult(BaseResponse result) {
        this.result = result;
    }

    public List<PacketDTO> getListPacketDTo() {
        return listPacketDTO;
    }

    public void setListPacketDTO(List<PacketDTO> listPacketDTo) {
        this.listPacketDTO = listPacketDTo;
    }
}
