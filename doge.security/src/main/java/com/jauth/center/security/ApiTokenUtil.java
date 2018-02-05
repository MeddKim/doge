package com.jauth.center.security;

import com.jauth.center.core.domain.ClientInfo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 加密生成jwt规范的token
 */
public class ApiTokenUtil implements Serializable {

    private static final long serialVersionUID = -3301605591108950415L;

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

//    @Value("${gate.api.secret}")
    private String secret = "mySecret";

//    @Value("${gate.api.expiration}")
    private Long expiration = 7200L; //过期时间，单位秒

    /**
     * 生成Token
     * @param clientInfo
     * @return
     */
    public String generateToken(ClientInfo clientInfo){
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put(CLAIM_KEY_USERNAME,clientInfo.getCode());
        claims.put(CLAIM_KEY_CREATED,new Date());

        return generateToken(claims);
    }

    String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String refresh(){

    }

    /**
     * 生成过期时间
     * @return
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }
}
