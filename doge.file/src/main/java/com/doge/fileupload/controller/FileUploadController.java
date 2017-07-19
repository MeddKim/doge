package com.doge.fileupload.controller;

import com.doge.fileupload.utils.UploadFileUtils;
import com.doge.fileupload.utils.UploadPathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Administrator
 * @date : 2017/7/17 0017
 * @Description:
 */
@RestController
//public class FileUploadController implements ServletContextAware{
public class FileUploadController {

//    private ServletContext servletContext;

//    @Autowired
//    private HttpServletRequest request;
//    @Autowired
//    private HttpServletResponse response;

//    @Override
//    public void setServletContext(ServletContext servletContext) {
//        this.servletContext = servletContext;
//    }

    @RequestMapping(value = "/file/upload",method = RequestMethod.POST)
    public void upload(HttpServletRequest request) throws IOException{
        request.setCharacterEncoding("utf8");

        //获取项目运行所在路径
        String rootPath = System.getProperty("user.dir");
        //文件存储路径
        String savePath = rootPath + File.separator + "upload";

        System.out.println();
        //创建通用多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());

        //判断是否有文件上传
        if(multipartResolver.isMultipart(request)){
            //转换为多部分request
//            MultipartHttpServletRequest multiRequest = multipartResolver.resolveMultipart(request);
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            //获取request中所有的文件名称
            Iterator<String> iterator = multiRequest.getFileNames();
            while (iterator.hasNext()){
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iterator.next());
                if(null != file){
                    //获取当前上传的文件名
                    String fileName = file.getOriginalFilename();
                    //定义上传路径
//                    String dirPath = servletContext.getRealPath("/files/");
                    String dirPath = UploadPathUtils.randomSavePath(savePath);
                    File dir = new File(dirPath);
                    if(!dir.exists()){
                        dir.mkdirs();
                    }
                    File localFile = new File(dir, UploadFileUtils.getRandomFileName(fileName));
                    file.transferTo(localFile);
                }
            }
        }else{

        }
    }


    @RequestMapping(value = "/file/upload",method = RequestMethod.GET)
    public void test() throws IOException{
//        request.setCharacterEncoding("utf8");
//
//        //获取项目运行所在路径
//        String rootPath = System.getProperty("user.dir");
//        //文件存储路径
//        String savePath = rootPath + File.separator + "upload";
//        System.out.println(savePath);
    }
}
