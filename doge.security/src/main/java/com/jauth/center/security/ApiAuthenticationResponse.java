package com.jauth.center.security;

import java.io.Serializable;

/**
 * Created by Meddkim on 2017/11/26.
 */
public class ApiAuthenticationResponse implements Serializable {
    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public ApiAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}