package com.doge.blog.entity;

import com.alibaba.druid.sql.builder.SQLBuilder;
import com.jfinal.annotation.DataModel;
import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * @author: Administrator
 * @date : 2017/5/23 0023
 * @Description:
 */
@DataModel(TableName = "blog_content")
public class Content extends Model<Content>{
    public static Content me = new Content();

    public List<Content> findContents(){
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT id,title,author, FROM ");
        sql.append(getTable().getName());

        return find(sql.toString());
    }
}
