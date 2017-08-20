package com.security.service;

import com.security.domain.SysUsers;

/**
 * Created by Meddkim on 2017/8/20.
 */
public interface ISysUsersService {
    SysUsers findUserByPrimaryKey(Long id);
    SysUsers findUserByName(String name);
}
