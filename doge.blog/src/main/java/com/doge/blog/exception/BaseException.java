package com.doge.blog.exception;

import com.doge.blog.utils.HttpCode;

/**
 * Created by Meddkim on 2017/9/23.
 */
public class BaseException extends RuntimeException{
    private int code;

    public BaseException(int code,String msg){
        super(msg);
        this.code = code;
    }

    public BaseException(HttpCode httpCode){
        super(httpCode.msg());
        this.code = httpCode.code();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
