package com.jfinal.resource;

import com.jfinal.kit.StrKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Administrator
 * @date : 2017/5/22 0022
 * @Description:
 */
public abstract class AbstractClassReader implements ClassReader{

    private static final Logger logger = LoggerFactory.getLogger(AbstractClassReader.class);

    public Set<ClassInfo> getClass(String packageName, boolean recursive){
        return this.getClassByAnnotation(packageName,null,null,recursive);
    }

    public Set<ClassInfo> getClass(String packageName, Class<?> parent,boolean recursive){
        return this.getClassByAnnotation(packageName,parent,null,recursive);
    }

    public Set<ClassInfo> getClassByAnnotation(String packageName, Class<? extends Annotation> annotation, boolean recursive){
        return this.getClassByAnnotation(packageName,null,annotation,recursive);
    }

    public Set<ClassInfo> getClassByAnnotation(String packageName, Class<?> parent,Class<? extends Annotation> annotation, boolean recursive){
        if(StrKit.isBlank(packageName)){
            throw new RuntimeException("包名不能为空");
        }
        Set<ClassInfo> classes = new HashSet<ClassInfo>();
        //将包名装换为路径
        String packageDirName = packageName.replace('.','/');

        //用于循环处理目录URL的枚举
        Enumeration<URL> dirs;
        try {
            dirs = this.getClass().getClassLoader().getResources(packageDirName);
            //迭代
            while (dirs.hasMoreElements()){
                URL url = dirs.nextElement();
                try {
                    //获取包的物理路径
                    String filePath = new URI(url.getFile()).getPath();
                    Set<ClassInfo> subClasses = findClassByPackage(packageName,filePath,parent,annotation,recursive,classes);
                    if(subClasses.size() >0){
                        classes.addAll(subClasses);
                    }
                }catch (URISyntaxException e){
                    logger.error(e.getMessage(),e);
                }
            }

        } catch (IOException e){
            logger.error(e.getMessage(),e);
        } catch (ClassNotFoundException e){
            logger.error("找不到类{}",e.getMessage());

        }

        return classes;
    }

    /**
     *
     * @param packageName 包名
     * @param packagePath 路径
     * @param parent 父类
     * @param annotation 注解
     * @param recursive 是否递归查找
     * @param classes
     * @return
     * @throws ClassNotFoundException
     */
    private Set<ClassInfo> findClassByPackage(final String packageName, final String packagePath,
                                              final Class<?> parent,  final Class<? extends Annotation> annotation,
                                              final boolean recursive, Set<ClassInfo> classes) throws ClassNotFoundException {


        //获取此包的路径,创建file对象
        File dir = new File(packagePath);
        //若不存在或者不是目录，直接返回
        if((!dir.exists()) || (!dir.isDirectory())){
            logger.warn("包{}不存在",packageName);
            return null;
        }
        //获取包下所有的文件，包括目录
        File[] dirfiles = accept(dir,recursive);

        // 循环所有文件
        if(null != dirfiles && dirfiles.length > 0){
            for (File file : dirfiles) {
                // 如果是目录 则继续扫描
                if (file.isDirectory()) {
                    findClassByPackage(packageName + "." + file.getName(), file.getAbsolutePath(), parent, annotation, recursive, classes);
                } else {
                    // 如果是java类文件 去掉后面的.class 只留下类名
                    String className = file.getName().substring(0, file.getName().length() - 6);
//                    Class<?> clazz = classLoader.defineClassByName(packageName + '.' + className);
                    Class<?> clazz = Class.forName(packageName + '.' + className);
                    if(null != parent && null != annotation){
                        if(null != clazz.getSuperclass() && clazz.getSuperclass().equals(parent) &&
                                null != clazz.getAnnotation(annotation)){
                            classes.add(new ClassInfo(clazz));
                        }
                        continue;
                    }
                    if(null != parent){
                        if(null != clazz.getSuperclass() && clazz.getSuperclass().equals(parent)){
                            classes.add(new ClassInfo(clazz));
                        } else {
                            if(null != clazz.getInterfaces() && clazz.getInterfaces().length > 0 && clazz.getInterfaces()[0].equals(parent)){
                                classes.add(new ClassInfo(clazz));
                            }
                        }
                        continue;
                    }
                    if(null != annotation){
                        if(null != clazz.getAnnotation(annotation)){
                            classes.add(new ClassInfo(clazz));
                        }
                        continue;
                    }
                    classes.add(new ClassInfo(clazz));
                }
            }
        }
        return classes;
    }

    private File[] accept(File file,final boolean recursive){
        File[] dirfiles = file.listFiles(new FileFilter() {
            //自定义过滤规则，包含
            @Override
            public boolean accept(File pathname) {
                return (recursive && file.isDirectory() || (file.getName().endsWith(".class")));
            }
        });
        return dirfiles;
    }
}
