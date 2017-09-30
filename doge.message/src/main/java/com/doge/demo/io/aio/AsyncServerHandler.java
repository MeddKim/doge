package com.doge.demo.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncServerHandler implements Runnable{

    public CountDownLatch latch;
    public AsynchronousServerSocketChannel channel;

    public AsyncServerHandler(int port){
        try {
            channel = AsynchronousServerSocketChannel.open();
            channel.bind(new InetSocketAddress(port));
            System.out.println("服务已经启动，端口为:"+port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //CountDownLatch初始化
        //作用：在完成一组正在执行的操作之前，允许当前的线程一直阻塞
        //让现场做社，防止服务端执行完成后退出
        //也可以用while(true) + sleep
        //生产环境服务器不会关闭不需要担心这个问题
        latch = new CountDownLatch(1);
        //接收客户端连接
        channel.accept(this,new AcceptHandler());

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
