package com.security.domain;

import lombok.Data;

/**
 * 来源于数据源 shiro3
 */

@Data
public class SysApp {

    private Integer id;
    private String name;
    private String appKey;
    private String appSecret;
    private Boolean available;
}
