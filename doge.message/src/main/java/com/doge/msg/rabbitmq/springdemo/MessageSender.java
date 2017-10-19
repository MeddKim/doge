package com.doge.msg.rabbitmq.springdemo;

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

}
