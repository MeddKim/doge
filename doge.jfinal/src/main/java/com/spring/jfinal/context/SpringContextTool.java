package com.spring.jfinal.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * @author: Administrator
 * @date : 2017/5/19 0019
 * @Description:
 */
@Component
public class SpringContextTool implements ApplicationContextAware{

    public static final Logger logger = LoggerFactory.getLogger(SpringContextTool.class);

    public static ApplicationContext context;

    private MessageSource messages;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String[] names = applicationContext.getBeanDefinitionNames();
        logger.info("开始打印bean");
        for(String name:names){
            System.out.println(name);
        }
        context = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }
}
