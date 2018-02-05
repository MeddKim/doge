package com.jauth.center.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 服务认证请求类，(内部服务)向授权中心请求token的时候必须带上这些信息，
 * 用于Spring Cloud微服务间的通讯安全
 *
 * 其中secret由模块管理中心发放
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String clientId;
    private String secret;
}
