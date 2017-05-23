package com.doge.blog.entity;

import com.jfinal.annotation.DataModel;
import com.jfinal.plugin.activerecord.Model;

/**
 * @author: Administrator
 * @date : 2017/5/23 0023
 * @Description: 附件类
 */
@DataModel(TableName = "blog_attachment")
public class Attachment extends Model<Attachment>{

    public static final Attachment me = new Attachment();

}
