package com.doge.blog.entity;

import com.jfinal.annotation.DataModel;
import com.jfinal.plugin.activerecord.Model;

/**
 * @author: Administrator
 * @date : 2017/5/23 0023
 * @Description:
 */
@DataModel(TableName = "blog_taxonomy")
public class Taxonomy extends Model<Taxonomy>{
    public static final Taxonomy me = new Taxonomy();
}
