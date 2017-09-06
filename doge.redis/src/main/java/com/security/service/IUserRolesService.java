package com.security.service;

import com.security.domain.UserRoles;

public interface IUserRolesService {

    UserRoles findUserByPrimaryKey(Long id);
}
