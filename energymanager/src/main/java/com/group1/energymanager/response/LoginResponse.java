package com.group1.energymanager.response;


public class LoginResponse {


        private BaseResponse result;
        private String username;
        private String password;

        public BaseResponse getResult() {
            return result;
        }

        public void setResult(BaseResponse result) {
            this.result = result;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


    }

