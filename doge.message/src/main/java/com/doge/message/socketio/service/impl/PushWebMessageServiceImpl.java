package com.doge.message.socketio.service.impl;

import com.corundumstudio.socketio.*;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.doge.message.socketio.service.PushWebMessageService;
import com.doge.message.socketio.utils.ServerHolder;
import com.doge.message.socketio.utils.ServerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class PushWebMessageServiceImpl implements PushWebMessageService {


    @Override
    public void addNameSpace(String serverName, String namespace) {

    }


    @Override
    public void push(String namespace, String clientId, String message, Map<String, Object> paramsMap) {

    }

    public void setListener(SocketIONamespace namespace){
        namespace.addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient client) {
                log.info("客户端已经连接{}",client.getSessionId());
            }
        });

        namespace.addEventListener("messsage",String.class,new DataListener(){
            @Override
            public void onData(SocketIOClient socketIOClient, Object o, AckRequest ackRequest) throws Exception {
                System.out.println(o);
            }
        });
    }

    public void testInit(){
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(9092);
        ServerInfo serverInfo = new ServerInfo("testServer",config);

        serverInfo.getServer().start();

        ServerHolder.add(serverInfo);


        ServerHolder.addNamespace("testServer","/chat1").addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient socketIOClient) {
                System.out.println("连接上");
            }
        });

        ServerHolder.addNamespace("testServer","/chat2").addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient socketIOClient) {
                System.out.println("连接上");
            }
        });
    }

    @Override
    public void pushTestMsg() {
        ServerHolder.namespaceMap.get("/chat1").getBroadcastOperations().sendEvent("message",new Member("张三",15,"测试人员"));
        ServerHolder.serverMap.get("testServer").getServer().getBroadcastOperations().sendEvent("messsage");
        System.out.println(ServerHolder.serverMap.get("testServer").getServer().getAllClients().size());
    }

    @Data
    @AllArgsConstructor
    public static class Member{
        private String name;
        private Integer age;
        private String desc;
    }
}
