package com.jfinal;

import com.Application;
import com.jfinal.annotation.DataModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * @author: Administrator
 * @date : 2017/5/19 0019
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Application.class)
public class BootTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(BootTest.class);
        annotationConfigApplicationContext.refresh();

        Map<String,Object> beans = annotationConfigApplicationContext.getBeansWithAnnotation(DataModel.class);

        System.out.println("---------打印--------");

        for(String key: beans.keySet()){
            System.out.println(key);
            System.out.println(beans.get(key));
        }
        System.out.println("---------打印--------");
    }
}
