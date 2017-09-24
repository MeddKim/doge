package com.doge.blog.utils;

/**
 * @author: Administrator
 * @date : 2017/6/2 0002
 * @Description:
 */
public enum HttpCode {
    /**
     * 200~299
     */
    SUCCESS(200,"操作成功！"),
    /**
     * 300~399
     */

    /**
     * 400~499
     */
    NOTFOUND(404,"未找到资源！"),
    PARAMSERROR(417,"参数异常"),
    /**
     * 500~599
     */
    SERVERERROR(500,"服务器异常");


    private int code;
    private String msg;

    HttpCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int code(){
        return this.code;
    }

    public String msg(){
        return this.msg;
    }

    public HttpCode setMsg(String msg){
        this.msg = msg;
        return this;
    }
}
