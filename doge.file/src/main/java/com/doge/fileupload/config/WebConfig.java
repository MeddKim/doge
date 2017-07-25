package com.doge.fileupload.config;


import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.io.IOException;

/**
 * @author: Administrator
 * @date : 2017/7/17 0017
 * @Description:
 */
@Configuration
public class WebConfig {

//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver createMultipartResolver() throws IOException {
//        CommonsMultipartResolver resolver=new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("utf-8");
//        return resolver;
//    }
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 设置文件大小限制 ,超出设置页面会抛出异常信息，
        // 这样在文件上传的地方就需要进行异常信息的处理了;
        factory.setMaxFileSize("1024MB"); // KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("10240MB");
        // 在该项目中，一下目录为临时文件存储的路径，传输完成后，临时文件删除
        String tempRootPath = System.getProperty("user.dir") + File.separator + "temp";
        File file = new File(tempRootPath);
        if(!file.exists()){
            file.mkdir();
        }
        factory.setLocation(tempRootPath);
//        factory.setFileSizeThreshold("10MB"); //设置缓存区有多少文件就写入到磁盘中
        return factory.createMultipartConfig();
    }

    @Bean(name = "multipartResolver")
    public StandardServletMultipartResolver resolver() {
        return new StandardServletMultipartResolver();
    }
}
