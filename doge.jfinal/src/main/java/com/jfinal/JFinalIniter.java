package com.jfinal;

import com.jfinal.annotation.DataModel;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.resource.ClassInfo;
import com.jfinal.resource.ClassPathClassReader;
import com.jfinal.resource.ClassReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.Set;

/**
 * @author: Meddkim
 * @date : 2017/5/21
 * @Description:
 */
public class JFinalIniter {


    private static Logger logger = LoggerFactory.getLogger(JFinalIniter.class);


    private ActiveRecordPlugin activeRecordPlugin;

    private DruidPlugin dataSourceProvider;

    private ClassReader classReader;

    public JFinalIniter(DruidPlugin provider, ActiveRecordPlugin plugin){
        this.dataSourceProvider = provider;
        this.activeRecordPlugin = plugin;
        if(null == classReader){
            classReader = new ClassPathClassReader();
        }

        Set<ClassInfo> classes = classReader.getClassByAnnotation("com.app",DataModel.class,true);

        for(ClassInfo classInfo:classes){
            DataModel model = classInfo.getClazz().getAnnotation(DataModel.class);

            //是否有model注解
            if(model != null){
                //获取id
                String primaryKey = model.Id();
                if(!StringUtils.hasLength(primaryKey)){
                    //默认主键为id
                    primaryKey = "id";
                }
                String tableName = model.TableName();
                if(!StringUtils.hasLength(tableName)){
                    logger.info("类{}中注解DataModel需要tableName参数",classInfo.getClassName());
                    continue;
                }

                activeRecordPlugin.addMapping(tableName,primaryKey, (Class<? extends Model<?>>) classInfo.getClazz());

            }
        }

        dataSourceProvider.start();
        activeRecordPlugin.start();
    }

    public JFinalIniter(ActiveRecordPlugin plugin,String modelBasePath){
        this.activeRecordPlugin = plugin;
        if(null == classReader){
            classReader = new ClassPathClassReader();
        }

        Set<ClassInfo> classes = classReader.getClassByAnnotation(modelBasePath,DataModel.class,true);

        for(ClassInfo classInfo:classes){
            DataModel model = classInfo.getClazz().getAnnotation(DataModel.class);

            //是否有model注解
            if(model != null){
                //获取id
                String primaryKey = model.Id();
                if(!StringUtils.hasLength(primaryKey)){
                    //默认主键为id
                    primaryKey = "id";
                }
                String tableName = model.TableName();
                if(!StringUtils.hasLength(tableName)){
                    logger.info("类{}中注解DataModel需要tableName参数",classInfo.getClassName());
                    continue;
                }

                activeRecordPlugin.addMapping(tableName,primaryKey, (Class<? extends Model<?>>) classInfo.getClazz());

            }
        }
        activeRecordPlugin.start();
    }

    /**
    public void init(){
        if(null != context){
            context = SpringContextTool.getApplicationContext();
        }

        String[] beanNames = context.getBeanNamesForType(Object.class);

        for(String name:beanNames){
            DataModel model = context.findAnnotationOnBean(name,DataModel.class);
            Object modelClass = context.getBean(name);

            //是否有model注解
            if(model != null){
                //获取id
                String primaryKey = model.Id();
                if(!StringUtils.hasLength(primaryKey)){
                    //默认主键为id
                    primaryKey = "id";
                }
                String tableName = model.TableName();
                if(!StringUtils.hasLength(tableName)){
                    logger.info("类{}中注解DataModel需要tableName参数",name);
                    continue;
                }

                activeRecordPlugin.addMapping(tableName,primaryKey, (Class<? extends Model<?>>) modelClass.getClass());

            }
        }

        dataSourceProvider.start();
        activeRecordPlugin.start();
    }
     **/
}
