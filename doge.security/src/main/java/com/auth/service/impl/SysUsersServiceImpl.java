package com.auth.service.impl;

import com.auth.domain.SysUsers;
import com.auth.mapper.SysUsersMapper;
import com.auth.service.ISysUsersService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Meddkim on 2017/8/20.
 */
@Service
@Slf4j
public class SysUsersServiceImpl implements ISysUsersService{

    @Autowired
    private SqlSession sqlSession;
    @Autowired
    private SysUsersMapper sysUsersMapper;

    @Override
    public SysUsers findUserByPrimaryKey(Long id) {

        log.info("查询用户ID为{}的用户",id);
        return sysUsersMapper.selectByPrimaryKey(id);
    }

    @Override
    public SysUsers findUserByName(String name) {
        return sysUsersMapper.selectUserByName(name);
    }

    @Override
    public int saveUser(SysUsers user) {
        return sysUsersMapper.insert(user);
    }
}
