package com.auth.service;

import com.auth.domain.SysRoles;

import java.util.List;
import java.util.Map;

public interface ISysRolesService {

    List<SysRoles> findByParams(Map<String,Object> params);
}
