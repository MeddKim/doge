package com.doge.demo.io.aio;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;

public class ReadHandler implements CompletionHandler<Integer,ByteBuffer>{
    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        //flip 操作
        attachment.flip();
        byte[] message = new byte[attachment.remaining()];
        attachment.get(message);

        try {
            String msg = new String(message,"UTF-8");
            System.out.println("服务器接收到消息："+msg);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void doWrite(){}
    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {

    }
}
