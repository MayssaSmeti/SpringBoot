package com.example.projecttt.dto;

import lombok.Builder;

@Builder
public class LoginResponse {
    private  String jwtToken;

    public String getJwtToken() {
        return jwtToken;
    }
    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
    public LoginResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
