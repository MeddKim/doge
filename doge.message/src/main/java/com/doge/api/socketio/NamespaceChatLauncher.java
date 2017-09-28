package com.doge.api.socketio;

import com.corundumstudio.socketio.*;
import com.corundumstudio.socketio.listener.DataListener;

public class NamespaceChatLauncher {
    public static void main(String[] args) throws InterruptedException {
        Configuration configuration = new Configuration();
        configuration.setHostname("localhost");
        configuration.setPort(9092);

        final SocketIOServer server = new SocketIOServer(configuration);
        final SocketIONamespace chat1namespace = server.addNamespace("/chat1");
        chat1namespace.addEventListener("message", ChatObject.class, new DataListener<ChatObject>() {
            @Override
            public void onData(SocketIOClient client, ChatObject data, AckRequest ackRequest){
                //broadcast message to all client
                chat1namespace.getBroadcastOperations().sendEvent("message",data);
            }
        });

        final SocketIONamespace chat2namespace = server.addNamespace("/chart2");
        chat2namespace.addEventListener("message", ChatObject.class, new DataListener<ChatObject>() {
            @Override
            public void onData(SocketIOClient client, ChatObject data, AckRequest ackRequest){
                //broadcast message to all client
                chat1namespace.getBroadcastOperations().sendEvent("message",data);
            }
        });

        server.start();

        Thread.sleep(Integer.MAX_VALUE);

        server.stop();
    }
}
