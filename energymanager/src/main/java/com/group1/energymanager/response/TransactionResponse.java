package com.group1.energymanager.response;

import com.group1.energymanager.DTOs.TransactionDTO;

public class TransactionResponse {
        private BaseResponse result;
        private TransactionDTO transaction;

        public TransactionResponse(BaseResponse result, TransactionDTO transaction) {
            this.result = result;
            this.transaction = transaction;
        }

    public TransactionResponse() {

    }


    public BaseResponse getResult() {
            return result;
        }

        public void setResult(BaseResponse result) {
            this.result = result;
        }

        public TransactionDTO getTransaction() {
            return transaction;
        }

        public void setTransaction(TransactionDTO transaction) {
            this.transaction = transaction;
        }
    }

