package com.jfinal.annotation;



import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.jamxin.framework.aop.Before;
import com.jamxin.framework.core.BaseController;
/**
 * @author: Administrator
 * @date : 2017/5/18 0018
 * @Description:
 */
@Component(value="annotationSearcher")
public class AnnotationSearcher extends SimpleMetadataReaderFactory {

    /**
     * Default maximum number of entries for the MetadataReader cache: 256
     */


    private static int cachelimit = 2048;
    private static int initcache = 256;
    private final String location = "classpath*:com/jamxin/**/*.class";
    //按照注解分
    private HashMap<Class, ArrayList<MetadataReader>> annotationHolder = new HashMap<Class, ArrayList<MetadataReader>>();
    @SuppressWarnings("serial")
    public static Map<Resource, MetadataReader> metadataReaderCache =
            new LinkedHashMap<Resource, MetadataReader>(initcache, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Resource, MetadataReader> eldest) {
                    return size() > cachelimit;
                }
            };

    public AnnotationSearcher() {
        Set<String> excludedMethodName = buildExcludedMethodName();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] resources = resolver.getResources(location);
            for (Resource resource : resources) {
                //如果资源可读就处理该资源
                if (resource.isReadable()) {
                    MetadataReader metadataReader = null;
                    try {
                        synchronized (this.metadataReaderCache) {
                            metadataReader = this.metadataReaderCache.get(resource);
                            if (metadataReader == null) {
                                metadataReader = super.getMetadataReader(resource);
                                this.metadataReaderCache.put(resource, metadataReader);
                            }
                            if (null == metadataReader) {
                                continue;
                            }
                            //如果该资源是annotation，说明是自定义的注解
                            if (metadataReader.getClassMetadata().isAnnotation()) {
                                //如果在注解持有者没有相关的注解，就创建一个
                                if (annotationHolder.get(metadataReader.getResource().getClass()) == null) {
                                    annotationHolder.put(metadataReader.getResource().getClass(), new ArrayList<MetadataReader>());
                                }
                            }
                            //如果不是接口也不是abstract类
                            else if (metadataReader.getClassMetadata().isConcrete()) {
                                //取出该资源所有的annotation
                                boolean sonOfController = (metadataReader.getClassMetadata().getSuperClassName().trim().endsWith(BaseController.class.getName().trim()));
                                Class tmp = Class.forName(metadataReader.getClassMetadata().getClassName(), false, classLoader);
                                Method[] methods = (sonOfController ? tmp.getDeclaredMethods() : tmp.getMethods());
                                //resource.getFile();
                                for (Method method : methods) {
                                    method.getAnnotations();
                                    String methodName = method.getName();
                                    if (excludedMethodName.contains(methodName) || method.getParameterTypes().length != 0)
                                        continue;
                                    if (sonOfController && !Modifier.isPublic(method.getModifiers()))
                                        continue;

									/*Interceptor[] methodInters = interceptorBuilder.buildMethodInterceptors(method);
									Interceptor[] actionInters = interceptorBuilder.buildActionInterceptors(globalInters, controllerInters, methodInters, method);
									String controllerKey = entry.getKey();

									ActionKey ak = method.getAnnotation(ActionKey.class);*/
									/*String actionKey;
									if (ak != null) {
										actionKey = ak.value().trim();
										if ("".equals(actionKey))
											throw new IllegalArgumentException(tmp.getName() + "." + methodName + "(): The argument of ActionKey can not be blank.");

										if (!actionKey.startsWith(SLASH))
											actionKey = SLASH + actionKey;
									}
									else if (methodName.equals("index")) {
										actionKey = controllerKey;
									}
									else {
										actionKey = controllerKey.equals(SLASH) ? SLASH + methodName : controllerKey + SLASH + methodName;
									}

									Action action = new Action(controllerKey, actionKey, controllerClass, method, methodName, actionInters, routes.getViewPath(controllerKey));
									if (mapping.put(actionKey, action) != null)
										throw new RuntimeException(buildMsg(actionKey, controllerClass, method));*/
                                }
                                Annotation[] aa = methods[0].getAnnotations();


                                ArrayList<MetadataReader> classMetaDatalist = annotationHolder.get(metadataReader.getResource().getClass());
                                if (null != classMetaDatalist && classMetaDatalist.size() > 0 && (!classMetaDatalist.contains(metadataReader))) {
                                    classMetaDatalist.add(metadataReader);
                                }
                            }
                        }
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }

                }
            }
            System.out.println("一共加载了" + (metadataReaderCache == null ? 0 : metadataReaderCache.size()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public int getInitcache() {
        return initcache;
    }

    public void setInitcache(int initcache) {
        this.initcache = initcache;
    }

    public int getCachelimit() {
        return cachelimit;
    }

    public void setCachelimit(int cachelimit) {
        this.cachelimit = cachelimit;
    }

    public void onApplicationEvent(ApplicationEvent event) {
        // TODO Auto-generated method stub
        //如果是容器刷新事件
        if (event instanceof ContextClosedEvent) {
            System.out.println(event.getClass().getSimpleName() + " 事件已发生！");
        } else if (event instanceof ContextRefreshedEvent) {//如果是容器关闭事件
            System.out.println(event.getClass().getSimpleName() + " 事件已发生！");
        } else if (event instanceof ContextStartedEvent) {
            System.out.println(event.getClass().getSimpleName() + " 事件已发生！");
        } else if (event instanceof ContextStoppedEvent) {
            System.out.println(event.getClass().getSimpleName() + " 事件已发生！");
        } else {
            System.out.println("有其它事件发生:" + event.getClass().getName());
        }
        System.out.println("hello~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private Set<String> buildExcludedMethodName() {
        Set<String> excludedMethodName = new HashSet<String>();
        Method[] methods = BaseController.class.getMethods();
        for (Method m : methods) {
            if (m.getParameterTypes().length == 0)
                excludedMethodName.add(m.getName());
        }
        return excludedMethodName;
    }
}