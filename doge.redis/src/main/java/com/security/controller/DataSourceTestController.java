package com.security.controller;


import com.security.service.ISysAppService;
import com.security.service.ISysUsersService;
import com.security.service.IUserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataSourceTestController {

    @Autowired
    private ISysUsersService sysUsersService;
    @Autowired
    private ISysAppService sysAppService;
    @Autowired
    private IUserRolesService userRolesService;

    @RequestMapping(value = "/get/from/shiro",method = RequestMethod.GET)
    public Object fromShiro(){
        return sysUsersService.findUserByPrimaryKey(1L);
    }
    @RequestMapping(value = "/get/from/shiro1",method = RequestMethod.GET)
    public Object fromShiro1(){
        return userRolesService.findUserByPrimaryKey(1L);
    }
    @RequestMapping(value = "/get/from/shiro3",method = RequestMethod.GET)
    public Object fromShiro3(){
        return sysAppService.findUserByPrimaryKey(1L);
    }
}
