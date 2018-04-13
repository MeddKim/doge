package com.jauth.center.biz;

import com.jauth.center.core.domain.ClientInfo;
import com.jauth.center.security.ApiTokenUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Meddkim on 2017/11/26.
 */
@Service
public class AuthBiz {
    private ApiTokenUtil jwtTokenUtil;
//    private GateService gateService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    /**
     * 使用clientId和secret与数据库中的数据对比，验证是否合法
     * @param clientId
     * @param secret
     * @return 返回生成的token
     */
    public String login(String clientId,String secret){
        ClientInfo clientInfo = null;
//        ClientInfo clientInfo = clientService.getClientInfo(clientId);
        String token = "";
        if(encoder.matches(secret,clientInfo.getSecret())){
            token = jwtTokenUtil.generateToken(clientInfo);
        }
        return token;
    }

    public String refresh(String oldToken){
//        final String token = oldToken.substring(tok)
//        if(oldToken)
        return null;
    }
}
