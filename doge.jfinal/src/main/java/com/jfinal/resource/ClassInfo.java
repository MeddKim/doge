package com.jfinal.resource;

/**
 * @author: Administrator
 * @date : 2017/5/22 0022
 * @Description:
 */
public class ClassInfo {
    //完整名称，包含包名
    private String className;
    private Class<?> clazz;

    public ClassInfo(String className){
        this.className = className;
    }

    public ClassInfo(Class<?> clazz){
        this.clazz = clazz;
        //clazz.getName获取的名称是包含包名的完整名称
        //如com.com.jfinal.resource.ClassInfo
        this.className = clazz.getName();
    }

    public ClassInfo(String className, Class<?> clazz){
        this.className = className;
        this.clazz = clazz;
    }

    public String getClassName(){
        return className;
    }

    public Class<?> getClazz(){
        return clazz;
    }

    /**
     * 获取类实例
     * @return
     */
    public Object newInstance() {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString(){
        return clazz.toString();
    }
}
