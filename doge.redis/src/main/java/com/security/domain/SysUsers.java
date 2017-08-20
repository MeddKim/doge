package com.security.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Meddkim on 2017/8/20.
 */
@Data
public class SysUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String password;
    private String salt;
    private Integer locked;
}
