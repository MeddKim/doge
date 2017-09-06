package com.security.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 来源于数据源 shiro3
 */

@Data
public class SysApp implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String appKey;
    private String appSecret;
    private Boolean available;
}
