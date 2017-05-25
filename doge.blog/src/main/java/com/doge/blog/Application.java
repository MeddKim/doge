package com.doge.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;

//@SpringBootConfiguration
@EnableAutoConfiguration
@MapperScan("com.doge.blog.mapper.anno")
public class Application
{
    public static void main( String[] args )
    {
//        ApplicationContext context = SpringApplication.run(Application.class, args);
//        System.out.println("----------------记录bean开始--------------------");
//        String[] beanNames =  context.getBeanDefinitionNames();
//        System.out.println("所以beanNames个数："+beanNames.length);
//        for(String bn:beanNames){
//            System.out.println(bn);
//        }
//        System.out.println("----------------记录bean结束--------------------");

        SpringApplication.run(Application.class);
    }
}
