package com.auth.service;

import com.auth.domain.SysRoles;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface ISysRolesService {

    List<SysRoles> findByParams(Map<String,Object> params);

    List<SysRoles> findByParams(Map<String,Object> params,RowBounds rowBounds);
}
