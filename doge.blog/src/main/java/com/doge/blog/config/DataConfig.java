package com.doge.blog.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Meddkim on 2017/9/23.
 */
@Configuration
public class DataConfig {
    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //指定扫描那个包
        mapperScannerConfigurer.setBasePackage("com.doge.blog.mapper");
        //指定哪种注解会自动生成Mapper实现类
        mapperScannerConfigurer.setAnnotationClass(org.springframework.stereotype.Repository.class);

        return mapperScannerConfigurer;
    }
}
