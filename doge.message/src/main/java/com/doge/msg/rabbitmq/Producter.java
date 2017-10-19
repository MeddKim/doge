package com.doge.msg.rabbitmq;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producter {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("meddkim.org");
        factory.setUsername("meddkim");
        factory.setPassword("meddkim");
        factory.setPort(2372);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        /**验证Direct Exchange**/
        channel.exchangeDeclare("DirectExchange", BuiltinExchangeType.DIRECT,false,false,null);
        channel.queueDeclare("QueuebindToDirectExchange",false,false,false,null);
        channel.queueBind("QueuebindToDirectExchange","DirectExchange","routingKey");
        String message = "Hello World,This is test for direct exchange";
        channel.basicPublish("DirectExchange","routingKey",null,message.getBytes());

        channel.close();
        connection.close();
    }
}
