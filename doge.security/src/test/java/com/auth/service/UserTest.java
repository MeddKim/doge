package com.auth.service;

import com.auth.domain.SysRoles;
import com.auth.domain.SysUsers;
import com.auth.domain.SysUsersRoles;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.SecurityApplication.class)
public class UserTest {

    @Autowired
    private ISysUsersRolesService sysUsersRolesService;
    @Autowired
    private ISysUsersService sysUsersService;
    @Autowired
    private ISysRolesService sysRolesService;
    @Test
    public void selectByUserId(){
        List<SysUsersRoles> sysUsersRoles = sysUsersRolesService.selectByUserId(1L);

        sysUsersRoles.forEach(item -> {
            System.out.println(item.getRoleId());
        });
    }

    @Test
    public void findUser(){
        SysUsers users = sysUsersService.findUserByPrimaryKey(1L);
        System.out.println(users.getUsername());
    }

    @Test
    public void findRolesByIds(){
        Long[] arr  = {1L,2L};
        List<SysRoles> roles = sysRolesService.findByParams(new ImmutableMap.Builder<String,Object>()
                .put("ids", Arrays.asList(arr))
                .build());

        roles.forEach(item -> {
            System.out.println(item.getRole());
        });
    }
}
