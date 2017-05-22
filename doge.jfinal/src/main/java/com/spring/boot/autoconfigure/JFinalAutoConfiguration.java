package com.spring.boot.autoconfigure;


import com.jfinal.JFinalIniter;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author: Administrator
 * @date : 2017/5/22 0022
 * @Description:
 */
@Configuration
//@ConditionalOnClass(ActiveRecordPlugin.class) //ConditionalOnClass(某个class位于类路径上，才会实例化一个Bean)
@ConditionalOnBean(DataSource.class)  //仅仅在当前上下文中存在某个对象时，才会实例化一个Bean
@EnableConfigurationProperties(JFinalProperties.class)
@AutoConfigureAfter(DataSourceAutoConfiguration.class)
public class JFinalAutoConfiguration {

    private final JFinalProperties properties;

    @Bean
    public ActiveRecordPlugin activeRecordPlugin(DataSource dataSource){
        return new ActiveRecordPlugin(dataSource);
    }

    @Bean
    public JFinalIniter jFinalIniter(ActiveRecordPlugin activeRecordPlugin){
        String modelBasePath = properties.getModelBasePath();
        return new JFinalIniter(activeRecordPlugin,modelBasePath);
    }

    public JFinalAutoConfiguration(JFinalProperties properties){
        this.properties = properties;
    }
}
