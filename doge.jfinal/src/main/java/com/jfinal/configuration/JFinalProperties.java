package com.jfinal.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: Administrator
 * @date : 2017/5/18 0018
 * @Description:
 */
@ConfigurationProperties(prefix = JFinalProperties.JFINAL_PREFIX)
public class JFinalProperties {

    public static final String JFINAL_PREFIX = "jfinal";


}
