package com.doge.demo.io.nio;

public class NIOServer {
    private static int DEFAULT_PORT = 9091;
    private static NIOServerHandle serverHandle;

    public static void start(){
        start(DEFAULT_PORT);
    }

    public static synchronized void start(int port){
        if(null != serverHandle){

        }
        NIOServerHandle serverHandle = new NIOServerHandle(port);
        new Thread(serverHandle,"server").start();
    }

}
