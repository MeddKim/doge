package com.doge.demo.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel,AsyncServerHandler>{

    @Override
    public void completed(AsynchronousSocketChannel channel, AsyncServerHandler serverHandler) {
        //继续接收其他客户端请求
        AIOServer.clientCount++;
        System.out.println("连接的客户端数目："+AIOServer.clientCount);
        serverHandler.channel.accept(serverHandler,this);
        //创建新的buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //异步读，第二个参数为接收消息回调业务的handler
//        channel.read(buffer,buffer,)
    }

    @Override
    public void failed(Throwable exc, AsyncServerHandler serverHandler) {
        exc.printStackTrace();
        serverHandler.latch.countDown();
    }
}
