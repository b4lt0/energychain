package com.group1.energymanager.response;

public class DeleteUserResponse {
        private BaseResponse result;
        private String id;

        public BaseResponse getResult() {
            return result;
        }

        public void setResult(BaseResponse result) {
            this.result = result;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

