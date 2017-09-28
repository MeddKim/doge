package com.doge.message.exception;

public class MessageException extends Exception{

    public MessageException(){
        super();
    }

    public MessageException(String msg){
        super(msg);
    }

    public MessageException(String msg,Throwable cause){
        super(msg,cause);
    }
}
