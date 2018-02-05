package com.jauth.center.controller;

import com.jauth.center.biz.AuthBiz;
import com.jauth.center.security.ApiAuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Meddkim on 2017/11/26.
 */

@RestController
@RequestMapping("/api/authen")
public class AuthController {

    @Autowired
    private AuthBiz authBiz;

    /**
     * 服务认证接口，服务通过提交的clientId和服务注册中想发放的secret合法性校验的校验
     * 通过校验的服务将被发放token
     * @param apiRequest
     * @return
     */
    @PostMapping(value = "/auth")
    public Object createAuthenticationToken(@RequestBody ApiAuthenticationRequest apiRequest){
        final String token = authBiz.login(apiRequest.getClientId(),apiRequest.getSecret());

        return token;
    }

    /**
     * 刷新并获取新的Token
     * @param token
     * @return
     */
    @RequestMapping(value = "refresh", method = RequestMethod.GET)
    public Object refreshAndGetAuthenticationToken(
            String token) {
        String refreshedToken = authBiz.refresh(token);
        if(refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return refreshedToken;
        }
    }
}
