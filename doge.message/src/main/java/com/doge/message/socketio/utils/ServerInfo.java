package com.doge.message.socketio.utils;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
public class ServerInfo {
    private String name;    //服务名称
    private Configuration config; //服务配置
    private SocketIOServer server;  //服务实例
    private Integer status; //服务状态
    public Map<String,SocketIOClient> clientMap;
    public Map<String,SocketIONamespace> namespaceMap;
//    private

    public ServerInfo(String name,Configuration config){
        this.name = name;
        this.config = config;
        this.status = 0;
        this.server = new SocketIOServer(config);
    }

    public void getConnectionSize(){
        this.getServer().getAllClients().size();
    }
}
