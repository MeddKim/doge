package com.doge.message.socketio.service;

import com.corundumstudio.socketio.SocketIONamespace;

import java.util.Map;

public interface PushWebMessageService {

    void addNameSpace(String serverName,String namespace);
    void push(String namespace, String clientId, String message, Map<String,Object> paramsMap);
    void testInit();
    void pushTestMsg();
}
