package com.auth.service.impl;

import com.auth.domain.SysUsers;
import com.auth.service.ISysUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meddkim on 2017/8/20.
 */
public class CustomUserService implements UserDetailsService{

    @Autowired
    private ISysUsersService sysUsersService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        SysUsers user = sysUsersService.findUserByName(name);

        if(null == user){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //添加角色列表
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        /*
        for(SysRole role:user.getRoles())
        {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            System.out.println(role.getName());
        }
        * */
        return new User(user.getUsername(),user.getPassword(),authorities);
    }
}