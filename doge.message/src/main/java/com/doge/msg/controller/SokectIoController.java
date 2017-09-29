package com.doge.msg.controller;

import com.doge.message.socketio.service.PushWebMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socketio")
public class SokectIoController {

    @Autowired
    PushWebMessageService pushWebMessageService;

    @RequestMapping("/init")
    public String test(){
        pushWebMessageService.testInit();
        return "hello";
    }

    @RequestMapping("/send")
    public String send(){
        pushWebMessageService.pushTestMsg();

        return "你好";
    }
}
