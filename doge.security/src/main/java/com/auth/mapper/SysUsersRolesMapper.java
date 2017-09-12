package com.auth.mapper;

import com.auth.domain.SysUsersRoles;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUsersRolesMapper {

    List<SysUsersRoles> selectByUserId(Long userId);
}
