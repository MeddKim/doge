package com.security.service;

import com.security.domain.SysApp;

public interface ISysAppService {
    SysApp findUserByPrimaryKey(Long id);
}
