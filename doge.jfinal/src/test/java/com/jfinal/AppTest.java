package com.jfinal;

import com.app.entity.SysApp;
import com.jfinal.annotation.DataModel;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author: Administrator
 * @date : 2017/5/17 0017
 * @Description:
 */
public class AppTest {

    public static void main(String[] args) {

//        DruidPlugin dp = new DruidPlugin("jdbc:mysql://118.190.74.13:3306/demo?useUnicode=true&characterEncoding=UTF-8",
//                "root","meddkim");
//
//        ActiveRecordPlugin plugin = new ActiveRecordPlugin(dp);
//        plugin.addMapping("sys_app", SysApp.class);
//        dp.start();
//        plugin.start();
//        SysApp sysApp = SysApp.me.findById(1L);
//        String jsonObj = sysApp.toJson();
//        System.out.println(jsonObj);
//        String screct = sysApp.get("app_secret");

//        SysApp sysApp = new SysApp();
//        sysApp.set("name","配置服务器");
//        sysApp.set("app_key","xxwwzzelajsldkflasdufosidjf");
//        sysApp.set("app_secret","kjaslkdjflkajsdfkljaslkdfj");
//        sysApp.set("available","1");
//        sysApp.save();

        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(AppTest.class);
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
