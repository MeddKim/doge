package com.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: Administrator
 * @date : 2017/5/22 0022
 * @Description:
 */
@ConfigurationProperties(prefix = JFinalProperties.MYBATIS_PREFIX)
public class JFinalProperties {
    public static final String MYBATIS_PREFIX = "jfinal";

    private String modelBasePath;


    public String getModelBasePath() {
        return modelBasePath;
    }

    public void setModelBasePath(String modelBasePath) {
        this.modelBasePath = modelBasePath;
    }
}
