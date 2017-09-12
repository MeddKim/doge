package com.auth.mapper;

import com.auth.domain.SysRoles;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysRolesMapper {

    List<SysRoles> findByParams(Map<String,Object> params);
}
