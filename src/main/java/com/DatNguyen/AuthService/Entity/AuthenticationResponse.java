package com.DatNguyen.AuthService.Entity;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class AuthenticationResponse {
    Map<String, String> tokens;

    public AuthenticationResponse(Map<String, String> tokens) {
        this.tokens = tokens;
    }

    public Map<String, String> getTokens() {
        return tokens;
    }

    public void setTokens(Map<String, String> tokens) {
        this.tokens = tokens;
    }
}