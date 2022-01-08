package com.group1.energymanager.response;
import java.util.List;

public class JWTResponse {

    public JWTResponse(String jwt, String id, String username, List<String> roles) {
    }

    public class JwtResponse {
        private String token;
        private String type = "Bearer";
        private String id;
        private String ragSociale;
        private String username;
        private float wallet;
        private List<String> roles;

        public JwtResponse(String accessToken, String id, String ragSociale, String username, float wallet, List<String> roles) {
            this.token = accessToken;
            this.id = id;
            this.ragSociale = ragSociale;
            this.username = username;
            this.wallet = wallet;
            this.roles = roles;
        }

        public String getAccessToken() {
            return token;
        }

        public void setAccessToken(String accessToken) {
            this.token = accessToken;
        }

        public String getTokenType() {
            return type;
        }

        public void setTokenType(String tokenType) {
            this.type = tokenType;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public float getWallet() {
            return wallet;
        }

        public void setWallet(float wallet) {
            this.wallet = wallet;
        }

        public String getRagSociale() {
            return ragSociale;
        }

        public void setRagSociale(String ragSociale) {
            this.ragSociale = ragSociale;
        }



        public List<String> getRoles() {
            return roles;
        }
    }
}
