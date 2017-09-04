package com.security.mapper;

import com.security.domain.SysUsers;
import org.springframework.stereotype.Repository;

/**
 * Created by Meddkim on 2017/8/20.
 */
@Repository
public interface SysUsersMapper {

    SysUsers selectByPrimaryKey(Long id);
    SysUsers selectUserByName(String username);
}
