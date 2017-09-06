package com.security.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 来源于数据源shiro1
 */
@Data
public class UserRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private String roleName;
}
