package com.jfinal.annotation;

import java.lang.annotation.*;

/**
 * @author: Administrator
 * @date : 2017/5/18 0018
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataModel {

    String TableName() default "";
    String Id() default "id";

}
