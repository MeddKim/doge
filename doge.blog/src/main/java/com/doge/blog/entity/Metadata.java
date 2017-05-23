package com.doge.blog.entity;

import com.jfinal.annotation.DataModel;
import com.jfinal.plugin.activerecord.Model;

/**
 * @author: Administrator
 * @date : 2017/5/23 0023
 * @Description:
 */
@DataModel(TableName = "blog_metadata")
public class Metadata extends Model<Metadata>{
    public static final Metadata me = new Metadata();
}
