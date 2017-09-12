package com.auth.service.impl;

import com.auth.domain.SysRoles;
import com.auth.mapper.SysRolesMapper;
import com.auth.service.ISysRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysRolesServiceImpl implements ISysRolesService {

    @Autowired
    private SysRolesMapper sysRolesMapper;

    @Override
    public List<SysRoles> findByParams(Map<String, Object> params) {
        return sysRolesMapper.findByParams(params);
    }
}
