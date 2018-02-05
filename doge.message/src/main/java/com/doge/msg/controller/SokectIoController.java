package com.doge.msg.controller;

import com.doge.message.socketio.service.PushWebMessageService;
import com.doge.msg.rabbitmq.springdemo.MessageSender;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socketio")
public class SokectIoController {

    @Autowired
    PushWebMessageService pushWebMessageService;
    @Autowired
    MessageSender messageSender;

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

    @RequestMapping("/test")
    public String test1(){
        messageSender.sendTest();
        return "hello";
    }


}
