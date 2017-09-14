package com.auth.service.impl;

import com.auth.domain.SysRoles;
import com.auth.domain.SysUsers;
import com.auth.domain.SysUsersRoles;
import com.auth.service.ISysRolesService;
import com.auth.service.ISysUsersRolesService;
import com.auth.service.ISysUsersService;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Meddkim on 2017/8/20.
 */
public class CustomUserService implements UserDetailsService{

    @Autowired
    private ISysUsersService sysUsersService;
    @Autowired
    private ISysUsersRolesService sysUsersRolesService;
    @Autowired
    private ISysRolesService sysRolesService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        SysUsers user = sysUsersService.findUserByName(name);

        if(null == user){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //添加角色列表
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        //根据用户ID获取角色列表
        List<SysUsersRoles> usersRoles = sysUsersRolesService.selectByUserId(user.getId());

        if(usersRoles.size() > 0){
            List<Long> roleIds = usersRoles.stream().map(SysUsersRoles::getRoleId).collect(Collectors.toList());
            List<SysRoles> roles = sysRolesService.findByParams(new ImmutableMap.Builder<String,Object>()
                    .put("ids",roleIds)
                    .build());

            roles.forEach( item -> {
                if (!Strings.isNullOrEmpty(item.getRole()))
                    authorities.add(new SimpleGrantedAuthority(item.getRole()));
            });
        }
        /*
        for(SysRole role:user.getRoles())
        {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            System.out.println(role.getName());
        }
        * */
        return new User(user.getUsername(),user.getPassword().trim(),authorities);
    }
}
