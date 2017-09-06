package com.security.service.impl;

import com.security.datasource.TargetDataSource;
import com.security.domain.SysApp;
import com.security.mapper.SysAppMapper;
import com.security.service.ISysAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysAppServiceImpl implements ISysAppService {

    @Autowired
    private SysAppMapper sysAppMapper;

    @Override
    @TargetDataSource(name="ds2")
    public SysApp findUserByPrimaryKey(Long id) {
        return sysAppMapper.selectByPrimaryKey(id);
    }
}
