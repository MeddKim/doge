package com.auth.service;

import com.auth.domain.SysUsersRoles;

import java.util.List;

public interface ISysUsersRolesService {

    List<SysUsersRoles> selectByUserId(Long userId);
}
