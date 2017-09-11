package com.auth.security;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class AuthenticationBean {
    private String username;
    private String password;
}
