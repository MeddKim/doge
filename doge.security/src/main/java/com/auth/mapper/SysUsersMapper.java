package com.auth.mapper;

import com.auth.domain.SysUsers;

/**
 * Created by Meddkim on 2017/8/20.
 */
public interface SysUsersMapper {

    SysUsers selectByPrimaryKey(Long id);
    SysUsers selectUserByName(String username);
}
