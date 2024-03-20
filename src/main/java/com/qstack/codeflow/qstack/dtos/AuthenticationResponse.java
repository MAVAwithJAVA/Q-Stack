package com.qstack.codeflow.qstack.dtos;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwtToken;

    public AuthenticationResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
