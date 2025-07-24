package com.project.SmartInvoiceTracker.dto.auth;

public class AuthResponse {

    private String token;

    public AuthResponse(String token) {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
