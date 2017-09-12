package com.auth.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUsersRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;
    private Long roleId;
}
