package com.doge.fileupload.utils;

import java.io.File;
import java.time.LocalDate;

/**
 * @author: Administrator
 * @date : 2017/7/17 0017
 * @Description:
 */
public class UploadPathUtils {

    /**
     * 生成一个存储文件路径
     * version 0.1 日期格式为 rootSavePath + 年/月/日
     * @param rootSavePath 文件存储根目录
     * @return
     */
    public static String randomSavePath(String rootSavePath){
        LocalDate date = LocalDate.now();

        StringBuffer path = new StringBuffer();
        path.append(rootSavePath);
        path.append(File.separator);
        path.append(date.getYear());
        path.append(File.separator);
        path.append(date.getMonth().getValue());
        path.append(File.separator);
        path.append(date.getDayOfMonth());
        path.append(File.separator);

        return path.toString();
    }
}
