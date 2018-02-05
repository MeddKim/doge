package com.doge.msg.rabbitmq.springdemo;

import com.doge.msg.controller.SokectIoController;
import com.doge.msg.controller.WebPushMessage;
import com.doge.msg.controller.WebPushMessages;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonObject;
import lombok.Data;
import org.assertj.core.util.Lists;
import org.json.JSONObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        amqpTemplate.convertAndSend("queue","Hello,Rabbit");
    }

    public void  sendTopicMessage(){
        amqpTemplate.convertAndSend("topicExchange","route.#","hello,Rabbit");
    }

    public void sendFanoutMessage(){
        amqpTemplate.convertAndSend("fanoutExchange","","hello,Rabbit");
    }

    public void sendTest(){
        WebPushMessages webPushMessages = new WebPushMessages();
        webPushMessages.setWebPushMessages(Lists.newArrayList());
        WebPushMessage webPushMessage1 = new WebPushMessage();
        WebPushMessage webPushMessage2 = new WebPushMessage();

        webPushMessage1.setAppClientType(WebPushMessage.AppClientType.BUYER);
        webPushMessage1.setAccountId("asdfasdf");
        webPushMessage1.setMessage("你好中国");
        webPushMessage1.setParamsMap(new ImmutableMap.Builder<String,Object>().put("name","harry").build());
        webPushMessage1.setPushCode(WebPushMessage.PushCode.OPEN_BUYER_ENQUIRY_DETAIL_PART);

        webPushMessage2.setAppClientType(WebPushMessage.AppClientType.VENDOR);
        webPushMessage2.setAccountId("oiiuetr");
        webPushMessage2.setMessage("你好世界");
        webPushMessage2.setParamsMap(new ImmutableMap.Builder<String,Object>().put("name","potter").build());
        webPushMessage2.setPushCode(WebPushMessage.PushCode.OPEN_BUYER_ORDER_LIST);

        webPushMessages.getWebPushMessages().add(webPushMessage1);
        webPushMessages.getWebPushMessages().add(webPushMessage2);

        amqpTemplate.convertAndSend("ms-push-to-web","",webPushMessages);
    }

}
