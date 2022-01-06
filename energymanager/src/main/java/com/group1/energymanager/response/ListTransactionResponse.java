package com.group1.energymanager.response;
import com.group1.energymanager.DTOs.TransactionDTO;

import java.util.List;

public class ListTransactionResponse {
    private BaseResponse result;
    private List<TransactionDTO> listTransactionDTO;

    public BaseResponse getResult() {
        return result;
    }

    public void setResult(BaseResponse result) {
        this.result = result;
    }

    public List<TransactionDTO> getLisTransactionDTo() {
        return listTransactionDTO;
    }

    public void setListTransactionDTO(List<TransactionDTO> listTransactionDTo) {
        this.listTransactionDTO = listTransactionDTo;
    }
}