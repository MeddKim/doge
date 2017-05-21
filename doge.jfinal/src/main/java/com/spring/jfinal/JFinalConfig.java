package com.spring.jfinal;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Meddkim
 * @date : 2017/5/21
 * @Description:
 */
@Configuration
public class JFinalConfig {

    @Bean
    public DruidPlugin druidPlugin(){
        DruidPlugin dp = new DruidPlugin("jdbc:mysql://118.190.74.13:3306/demo?useUnicode=true&characterEncoding=UTF-8",
                "root","meddkim");

        return  dp;
    }

    @Bean
    public ActiveRecordPlugin activeRecordPlugin(DruidPlugin druidPlugin){
        return new ActiveRecordPlugin(druidPlugin);
    }

}
