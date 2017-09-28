package com.doge.blog.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Created by Meddkim on 2017/9/23.
 */
@Data
public class SuccessOrFailResp {
    private int code;
    private String msg;
    private Object data;


    public SuccessOrFailResp(int code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public SuccessOrFailResp(int code,String msg){
        this.code = code;
        this.msg = msg;
        this.data = null;
    }


    public SuccessOrFailResp(String msg,Object data){
        this.code = HttpCode.SUCCESS.code();
        this.msg = msg;
        this.data = data;
    }
    public SuccessOrFailResp(Object data){
        this.code = HttpCode.SUCCESS.code();
        this.msg = HttpCode.SUCCESS.msg();
        this.data = data;
    }
}
