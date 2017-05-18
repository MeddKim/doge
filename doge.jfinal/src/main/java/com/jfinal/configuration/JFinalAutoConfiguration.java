package com.jfinal.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author: Administrator
 * @date : 2017/5/17 0017
 * @Description:
 */
@Configuration
@ConditionalOnBean(DataSource.class)
public class JFinalAutoConfiguration {

}
