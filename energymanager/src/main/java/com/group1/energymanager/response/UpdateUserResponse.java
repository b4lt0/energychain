package com.group1.energymanager.response;

public class UpdateUserResponse {
        private BaseResponse result;
        private String id;
        private String ragSociale;
        private String username;
        private String password;

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

        public String getragSociale() {
            return ragSociale;
        }

        public void setRagSociale(String ragSociale) {
            this.ragSociale = ragSociale;
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

