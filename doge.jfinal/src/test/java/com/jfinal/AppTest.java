package com.jfinal;

import com.alibaba.druid.pool.DruidDataSource;
//import com.app.entity.SysApp;
//import com.app.test.SysOrganization;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * @author: Administrator
 * @date : 2017/5/17 0017
 * @Description:
 */
public class AppTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

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

//        AnnotationConfigApplicationContext annotationConfigApplicationContext =
//                new AnnotationConfigApplicationContext();
//        annotationConfigApplicationContext.register(AppTest.class);
//        annotationConfigApplicationContext.refresh();
//
//        Map<String,Object> beans = annotationConfigApplicationContext.getBeansWithAnnotation(DataModel.class);
//
//        System.out.println("---------打印--------");

//        for(String key: beans.keySet()){
//            System.out.println(key);
//            System.out.println(beans.get(key));
//        }
//
//        SysApp sysApp = SysApp.me.findById(1L);
//        System.out.println(sysApp.toJson());
//        System.out.println("---------打印--------");


//        ClassPathClassReader reader = new ClassPathClassReader();
//        Set<ClassInfo> classInfoSet = reader.getClassByAnnotation("com.app",DataModel.class,true);
//        for (ClassInfo info:
//             classInfoSet) {
//            Class cla = info.getClazz();
//            System.out.println(cla);
//            DataModel dataModel = (DataModel) cla.getAnnotation(DataModel.class);
//            System.out.println(dataModel.TableName());
//        }

//        DruidPlugin dp = new DruidPlugin("jdbc:mysql://118.190.74.13:3306/demo?useUnicode=true&characterEncoding=UTF-8",
//                "root","meddkim");
//        ActiveRecordPlugin plugin = new ActiveRecordPlugin(dp);
//
//        JFinalIniter initer = new JFinalIniter(dp,plugin);
//
//        SysApp sysApp = SysApp.me.findById(1L);
//        String secret = sysApp.getStr("app_secret");
//        System.out.println(secret);
//
//        SysOrganization organization = SysOrganization.me.findById(1L);
//        System.out.println(organization.getStr("name"));


//        SysApp sysApp = new SysApp();
//        System.out.println("-------------start-------------");
//        System.out.println(sysApp.getClass().getClassLoader().getResource("").getPath());
////        System.out.println(sysApp.getClass().getClassLoader().getResource("/").getPath()); 错误
//        System.out.println(sysApp.getClass().getClassLoader().getResource("com/app").getPath());
//        System.out.println(sysApp.getClass().getClassLoader().getResource("ctx/").getPath());
//        System.out.println(sysApp.getClass().getClassLoader().getResource("com/").getPath());
//
//        System.out.println("-----------华丽的分割线---------------");
//
//        System.out.println(SysApp.class.getResource("").getPath());
//        System.out.println(SysApp.class.getResource("/").getPath());
//        System.out.println(SysApp.class.getResource("/com/app").getPath());
//        System.out.println(SysApp.class.getResource("/ctx").getPath());
//        System.out.println(SysApp.class.getResource("/com").getPath());
////        System.out.println(SysApp.class.getResource("com").getPath()); //错误
////        System.out.println(SysApp.class.getResource("ctx").getPath()); //错误
//
//        System.out.println("-------------end-------------");




//        DruidDataSource druidDataSource = new DruidDataSource();

//        DruidPlugin dp = new DruidPlugin("jdbc:mysql://118.190.74.13:3306/demo?useUnicode=true&characterEncoding=UTF-8",
//                "root","meddkim");
//        ActiveRecordPlugin plugin = new ActiveRecordPlugin(dp);

//        druidDataSource.setUrl("jdbc:mysql://118.190.74.13:3306/demo?useUnicode=true&characterEncoding=UTF-8");
//        druidDataSource.setUsername("root");
//        druidDataSource.setPassword("meddkim");
//        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//
//        ActiveRecordPlugin plugin = new ActiveRecordPlugin(druidDataSource);
//
//        JFinalIniter initer = new JFinalIniter(plugin,"com.app");
//
//        SysApp sysApp = SysApp.me.findById(1L);
//        String secret = sysApp.getStr("app_secret");
//        System.out.println(secret);
//
//        SysOrganization organization = SysOrganization.me.findById(1L);
//        System.out.println(organization.getStr("name"));

    }

}
