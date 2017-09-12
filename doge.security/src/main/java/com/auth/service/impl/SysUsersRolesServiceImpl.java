package com.auth.service.impl;

import com.auth.domain.SysUsersRoles;
import com.auth.mapper.SysUsersRolesMapper;
import com.auth.service.ISysUsersRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUsersRolesServiceImpl implements ISysUsersRolesService{

    @Autowired
    private SysUsersRolesMapper sysUsersRolesMapper;
    @Override
    public List<SysUsersRoles> selectByUserId(Long userId) {
        return sysUsersRolesMapper.selectByUserId(userId);
    }
}
