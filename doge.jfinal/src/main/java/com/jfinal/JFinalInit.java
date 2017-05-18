package com.jfinal;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.IDataSourceProvider;

/**
 * @author: Administrator
 * @date : 2017/5/18 0018
 * @Description:
 */
public class JFinalInit {

    private ActiveRecordPlugin recordPlugin;
    private IDataSourceProvider provider;



    public JFinalInit(ActiveRecordPlugin recordPlugin, IDataSourceProvider provider){
        this.recordPlugin  = recordPlugin;
        this.provider = provider;
        init();
    }

    private void init() {
        initDataSourceProvider();
        initActiveRecordPlugin();

    }

    public void setRecordPlugin(ActiveRecordPlugin recordPlugin) {
        this.recordPlugin = recordPlugin;
    }

    public void setProvider(IDataSourceProvider provider) {
        this.provider = provider;
    }

    private void initDataSourceProvider(){

    }

    private void initActiveRecordPlugin(){

    }
}
