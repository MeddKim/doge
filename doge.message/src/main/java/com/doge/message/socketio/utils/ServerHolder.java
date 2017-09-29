package com.doge.message.socketio.utils;

import com.corundumstudio.socketio.SocketIONamespace;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Slf4j
public class ServerHolder {

        private ServerHolder(){}
        //保存当前正在执行的SocketioServer
        //保存用户创建Server实例
        public static ConcurrentHashMap<String,ServerInfo> serverMap = new ConcurrentHashMap<String,ServerInfo>();
        public static ConcurrentHashMap <String,SocketIONamespace> namespaceMap= new ConcurrentHashMap<String,SocketIONamespace>();

        public static void  add(ServerInfo serverInfo){
            if(serverMap.containsKey(serverInfo.getName())){
               log.info("该服务已经存在");
            }
            serverMap.put(serverInfo.getName(),serverInfo);
        }
        public static void start(String name){
            if(!serverMap.containsKey(name)){
                log.info("不存在");
                return;
            }
            if(serverMap.get(name).getStatus() == 1){
                log.info("该服务已经启动");
                return;
            }
            serverMap.get(name).getServer().start();
            serverMap.get(name).setStatus(1);
        }
        public static void close(String name){
            if(!serverMap.containsKey(name)){
                log.info("该服务已经存在");
                return;
            }
            serverMap.get(name).getServer().stop();
            serverMap.get(name).setStatus(0);
        }
        public static void destroy(String name){
            if(!serverMap.containsKey(name)){
                log.info("不存在");
            }
            serverMap.remove(name);
        }

        public static SocketIONamespace addNamespace(String serverName,String nameSpace){
            if(!serverMap.containsKey(serverName)){
                log.info("不存在");
            }
            SocketIONamespace namespace = serverMap.get(serverName).getServer().addNamespace(nameSpace);
            namespaceMap.put(nameSpace,namespace);
            log.info("给{}创建房间{}",serverName,nameSpace);
            return namespace;
        }
}
