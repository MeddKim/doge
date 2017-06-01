package com.doge.blog.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

/**
 * @author: Administrator
 * @date : 2017/6/1 0001
 * @Description:
 */
public class DateUtils {

    public static void main(String[] args) {

        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
    }

    /**
     * 获取当前日期 ,
     * 需要字符形式的日期可以使用 toString(),格式为XXXX-XX-XX
     * @return
     */
    public static LocalDate getLocalDate(){
        return LocalDate.now();
    }

}
