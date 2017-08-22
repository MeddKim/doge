package com.security.controller;

import com.security.utils.HttpCode;
import com.security.utils.ResultMapUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Meddkim on 2017/8/22.
 */
@RestController
public class LoginController {

    @RequestMapping("/login-success")
    public Object loginSuccess() {
        return ResultMapUtils.successResult("登录成功");
    }

}
