package com.spring.jfinal;

import com.jfinal.annotation.DataModel;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.IDataSourceProvider;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.druid.DruidPlugin;
import com.spring.jfinal.context.SpringContextTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author: Meddkim
 * @date : 2017/5/21
 * @Description:
 */
@Component
public class JFinalIniter {

    private static Logger logger = LoggerFactory.getLogger(JFinalIniter.class);

    //spring上下文
    private ApplicationContext context;

    private ActiveRecordPlugin activeRecordPlugin;

    private DruidPlugin dataSourceProvider;


    public JFinalIniter(DruidPlugin dataSourceProvider, ActiveRecordPlugin activeRecordPlugin){
        this.dataSourceProvider = dataSourceProvider;
        this.activeRecordPlugin = activeRecordPlugin;
    }


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
}
