package com.doge.blog.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: Administrator
 * @date : 2017/5/31 0031
 * @Description:
 */
public class ResultMapUtils {

    public interface HTTPSTATUS{
        int SUCCESS = 200;
    }

    public static Map successResult(Object obj){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",HTTPSTATUS.SUCCESS);
        resultMap.put("data",obj);
        return resultMap;
    }

    public static Map errorResult(Object obj){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",HTTPSTATUS.SUCCESS);
        resultMap.put("message",obj);
        return resultMap;
    }
}
