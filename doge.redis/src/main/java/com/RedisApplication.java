package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author: Administrator
 * @date : 2017/5/19 0019
 * @Description:
 */
@SpringBootApplication
public class RedisApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RedisApplication.class, args);
        System.out.println("----------------记录bean开始--------------------");
        String[] beanNames =  context.getBeanDefinitionNames();
        System.out.println("所以beanNames个数："+beanNames.length);
        for(String bn:beanNames){
            System.out.println(bn);
        }
        System.out.println("----------------记录bean结束--------------------");
    }
}
