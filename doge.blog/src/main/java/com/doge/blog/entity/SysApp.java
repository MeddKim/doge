package com.doge.blog.entity;

import com.jfinal.annotation.DataModel;
import com.jfinal.plugin.activerecord.Model;

/**
 * @author: Administrator
 * @date : 2017/5/22 0022
 * @Description:
 */
@DataModel(TableName = "sys_app")
public class SysApp extends Model<SysApp>{
    public static final SysApp me = new SysApp();
}
