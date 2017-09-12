package com.auth.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String role;
    private String description;
    private Integer available;
}
