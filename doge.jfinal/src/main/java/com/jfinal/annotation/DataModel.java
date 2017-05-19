package com.jfinal.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author: Administrator
 * @date : 2017/5/18 0018
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface DataModel {

    String TableName() default "";
    String Id() default "id";

}
