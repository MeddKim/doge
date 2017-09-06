package com.security.mapper;

import com.security.domain.UserRoles;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesMapper {
    UserRoles selectByPrimaryKey(Long id);
}
