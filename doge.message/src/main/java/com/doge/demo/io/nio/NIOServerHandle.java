package com.doge.demo.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class NIOServerHandle implements Runnable{

    private Selector selector;
    private ServerSocketChannel serverChannel;
    private volatile boolean started;

    public NIOServerHandle(int port){
        try {
            //创建选择器
            selector = Selector.open();
            //打开监听通道
            serverChannel = ServerSocketChannel.open();
            //true:该通道设置为阻塞模式，false设置为非阻塞模式
            serverChannel.configureBlocking(false);
            //绑定端口,并设置backlog
            serverChannel.socket().bind(new InetSocketAddress(port),1024);
            //监听客户端请求
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            //标记服务已开启
            started = true;
            System.out.println("服务器已启动:"+port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {

    }

    public void stop(){
        started = false;
    }
}
