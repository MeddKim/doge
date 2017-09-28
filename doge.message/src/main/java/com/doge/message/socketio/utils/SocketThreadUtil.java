package com.doge.message.socketio.utils;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SocketThreadUtil extends Thread{
    public static SocketIOServer socketIOServer;

    public static void startSocketThread(){
        SocketThreadUtil thread = new SocketThreadUtil();
        thread.start();
    }
    public void run(){
        try{
            socketIOServer.startAsync();
            log.debug("socketio server started");
        }catch(Exception e){
            log.error("socketio server failed to start,see this message:",e.getMessage());
        }

    }

    public static void closeSocketIOServer(){
        if(socketIOServer!=null){
            socketIOServer.stop();
        }
    }
    public static int socketClientNum(){
        return socketIOServer.getAllClients().size();
    }
}
