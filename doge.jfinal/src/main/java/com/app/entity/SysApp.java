package com.app.entity;

import com.jfinal.annotation.DataModel;
import com.jfinal.plugin.activerecord.Model;

/**
 * @author: Administrator
 * @date : 2017/5/16 0016
 * @Description:
 */
@DataModel
public class SysApp extends Model<SysApp> {

    public static final SysApp me = new SysApp();
}
