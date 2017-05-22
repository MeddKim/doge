package com.doge.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */
public class Application
{
    public static void main( String[] args )
    {
        ApplicationContext context = SpringApplication.run(com.Application.class, args);
        System.out.println("----------------记录bean开始--------------------");
        String[] beanNames =  context.getBeanDefinitionNames();
        System.out.println("所以beanNames个数："+beanNames.length);
        for(String bn:beanNames){
            System.out.println(bn);
        }
        System.out.println("----------------记录bean结束--------------------");
    }
}
