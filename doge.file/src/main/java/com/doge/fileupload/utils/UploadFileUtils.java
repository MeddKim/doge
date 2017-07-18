package com.doge.fileupload.utils;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author: Administrator
 * @date : 2017/7/18 0018
 * @Description:
 */
public class UploadFileUtils {

    /***
     * 获取一个随机文件名称
     * version 0.1 文件名称由时间加上uuid
     * @return
     */
    public static String getRandomFileName(String rootName){

        String newFielName = UUID.randomUUID().toString()+ "-" + rootName;
        return newFielName;
    }
}
