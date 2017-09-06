package com.security.service.impl;

import com.security.datasource.TargetDataSource;
import com.security.domain.UserRoles;
import com.security.mapper.UserRolesMapper;
import com.security.service.IUserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRolesServiceImpl implements IUserRolesService{

    @Autowired
    private UserRolesMapper userRolesMapper;
    @Override
    @TargetDataSource(name="ds1")
    public UserRoles findUserByPrimaryKey(Long id) {
        return userRolesMapper.selectByPrimaryKey(id);
    }
}
