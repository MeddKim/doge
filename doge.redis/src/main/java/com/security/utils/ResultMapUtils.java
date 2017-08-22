package com.security.utils;

/**
 * Created by Meddkim on 2017/8/22.
 */
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Administrator
 * @date : 2017/5/31 0031
 * @Description:
 */
public class ResultMapUtils {

    public interface HTTPSTATUS{

    }

    public static Map successResult(Object obj){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",HttpCode.SUCCESS);
        resultMap.put("data",obj);
        return resultMap;
    }

    public static Map errorResult(int code,Object obj){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",code);
        resultMap.put("message",obj);
        return resultMap;
    }
}
