package com.jfinal;

import com.doge.fileupload.utils.UploadFileUtils;
import com.doge.fileupload.utils.UploadPathUtils;

import java.time.*;

/**
 * @author: Administrator
 * @date : 2017/7/18 0018
 * @Description:
 */
public class DateTest {

    public static void main(String[] args) {

        String path = UploadFileUtils.getRandomFileName("张三.jpg");
        System.out.println(path);
    }
}
