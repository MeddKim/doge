package com.doge.demo.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public final class ServerNormal {
    //默认端口
    private static int DEFAULT_PORT = 9091;
    //单例的ServerSocket
    private static ServerSocket server;

    public static void start() throws IOException {
        start(DEFAULT_PORT);
    }

    public static void start(int port) throws IOException {
        if(null != server){
            return ;
        }
        try {
            //通过构造函数创建ServerSocket
            //若端口正常且空闲，服务器就监听成功
            server = new ServerSocket(port);
            System.out.println("服务器已启动，端口号是"+port);
            System.out.println("服务器线程信息："+Thread.currentThread().getName());
            while (true){
                System.out.println("创建------socket-------");
                Socket socket = server.accept();
                new Thread(new ServerHandler(socket)).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //清理工作
            if(null != server){
                server.close();
                System.out.println("服务器已关闭");
                server = null;
            }
        }
    }
}
