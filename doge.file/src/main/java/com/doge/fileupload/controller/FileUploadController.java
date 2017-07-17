package com.doge.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author: Administrator
 * @date : 2017/7/17 0017
 * @Description:
 */
@Controller
public class FileUploadController implements ServletContextAware{

    private ServletContext servletContext;

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @RequestMapping(value = "/file/upload",method = RequestMethod.POST)
    public void upload() throws IOException{
        request.setCharacterEncoding("utf8");

        //创建通用多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(servletContext);
        //判断是否有文件上传
        if(multipartResolver.isMultipart(request)){
            //转换为多部分request
            MultipartHttpServletRequest multiRequest = multipartResolver.resolveMultipart(request);
            //获取request中所有的文件名称
            Iterator<String> iterator = multiRequest.getFileNames();
            while (iterator.hasNext()){
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iterator.next());
                if(null != file){
                    //获取当前上传的文件名
                    String fileName = file.getOriginalFilename();
                    //定义上传路径
                    String dirPath = servletContext.getRealPath("/files/");
                    File idr = new File(dirPath);
                    File dir = new File(dirPath);
                    if(!dir.exists()){
                        dir.mkdirs();
                    }
//                    File localFile = new File(dir, NoteUtil.creatId().substring(30)+"-"+fileName);
//                    file.transferTo(localFile);
                }
            }
        }else{

        }
    }
}
