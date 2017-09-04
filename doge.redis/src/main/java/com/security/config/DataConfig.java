package com.security.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {

    /***
     * 配置该类可以扫描指定包下的Mapper生成实例。
     * 不再需要要在使用 session.getMapper(someMapper.class)这种形式
     * @return
     */
    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //指定扫描那个包
        mapperScannerConfigurer.setBasePackage("com.security.mapper");
        //指定哪种注解会自动生成Mapper实现类
        mapperScannerConfigurer.setAnnotationClass(org.springframework.stereotype.Repository.class);

        return mapperScannerConfigurer;
    }
}
