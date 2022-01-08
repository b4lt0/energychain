package com.group1.energymanager.request;
import java.util.Set;


    public class SignupRequest {

        private String username;


        private String ragSociale;

        private Set<String> role;

        private String password;

        private float wallet;

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

        public String getRagSociale() {
            return ragSociale;
        }

        public void setRagSociale(String ragSociale) {
            this.ragSociale = ragSociale;
        }

        public Set<String> getRole() {
            return role;
        }

        public void setRole(Set<String> role) {
            this.role = role;
        }

        public float getWallet() {
            return wallet;
        }

        public void setWallet(float wallet) {
            this.wallet = wallet;
        }
    }

