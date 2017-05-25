package com.doge.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: Meddkim
 * @date : 2017/5/22
 * @Description:
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    /**
     @Bean
     public InternalResourceViewResolver resolver(){
     InternalResourceViewResolver resolver = new InternalResourceViewResolver();
     //        resolver.setViewClass();
     //        resolver.setPrefix("templates/");
     resolver.setSuffix(".html");
     return resolver;
     }


     @Override
     public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
     configurer.enable();
     }
     **/


    /**
     *Spring Boot 默认配置的/**映射到/static（或/public ，/resources，/META-INF/resources），
     * 优先级顺序为：META/resources > resources > static > public
     * /webjars/**会映射到classpath:/META-INF/resources/webjars/。
     * 注意：上面的/static等目录都是在classpath:下面。
     * 如果你想增加如/templates/**映射到classpath:/templates/，你可以让你的配置类继承WebMvcConfigurerAdapter，
     * 然后重写如下方法
     *
     * 使用，需要
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/"); //访问 localhost:8080/templates/admin/index.html
        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/");
        super.addResourceHandlers(registry);
    }
}

