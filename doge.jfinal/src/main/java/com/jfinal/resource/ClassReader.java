package com.jfinal.resource;

import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * @author: Administrator
 * @date : 2017/5/22 0022
 * @Description: 类读取器接口
 */
public interface ClassReader {

    Set<ClassInfo> getClass(String packageName, boolean recursive);

    Set<ClassInfo> getClass(String packageName, Class<?> parent,boolean recursive);

    Set<ClassInfo> getClassByAnnotation(String packageName, Class<? extends Annotation> annotation, boolean recursive);

    Set<ClassInfo> getClassByAnnotation(String packageName, Class<?> parent,Class<? extends Annotation> annotation, boolean recursive);
}
