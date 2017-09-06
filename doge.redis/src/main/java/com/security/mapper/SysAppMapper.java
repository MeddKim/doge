package com.security.mapper;

import com.security.domain.SysApp;
import org.springframework.stereotype.Repository;

@Repository
public interface SysAppMapper {
    SysApp selectByPrimaryKey(Long id);
}
