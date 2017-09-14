package com.auth.controller;

import com.auth.domain.SysRoles;
import com.auth.domain.SysUsers;
import com.auth.service.ISysRolesService;
import com.auth.service.ISysUsersService;
import com.auth.utils.PaginationList;
import com.auth.utils.PaginationUtils;
import com.auth.utils.ResultMapUtils;
import com.auth.utils.UUIDUtils;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RootController {

    @Autowired
    private ISysRolesService sysRolesService;
    @Autowired
    ISysUsersService iSysUsersService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/user/test")
    public String userTest() {
        System.out.println("你拥有一下角色：");
        SecurityContextHolder.getContext().getAuthentication().getAuthorities().forEach(item-> {
            System.out.println("-----"+item.getAuthority());;
        });
        return "你已经登录";
    }

    @RequestMapping("/admin/test")
    public String adminTest() {
        return "你已经登录，你拥有admin角色";
    }

    @RequestMapping("/employee/test")
    public String employeeTest() {
        return "你已经登录，你拥有employee角色";
    }

    @RequestMapping("/find/role")
    public Object findByParams(@RequestParam(name = "page",defaultValue = "1" ) Integer page,
                                 @RequestParam(name = "limit", defaultValue = "1") Integer limit) {


        List<SysRoles> sysRolesList = sysRolesService.findByParams(new ImmutableMap.Builder<String,Object>()
                .build(),PaginationUtils.getRowBounds(page,limit));

        List<RoleResp> roleResps = PaginationUtils.isPagination(page,limit) ?
                new PaginationList<>(sysRolesList): Lists.newLinkedList();

        roleResps.addAll(sysRolesList.stream().map(item->{
            RoleResp roleResp = new RoleResp();
            BeanUtils.copyProperties(item,roleResp);
            return roleResp;
        }).collect(Collectors.toList()));

        return roleResps;
    }

    @Data
    private static class RoleResp{
        private Long id;
        private String role;
        private String description;
    }

    @RequestMapping("/register")
    public Object register(@RequestBody SysUsers user){
        if(StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())){
            return ResultMapUtils.errorResult(331,"用户名或密码不能为空");
        }

        if(null != iSysUsersService.findUserByName(user.getUsername())){
            return ResultMapUtils.errorResult(331,"该用户已经存在");
        }
        user.setSalt(UUIDUtils.uuid());
        user.setPassword(passwordEncoder.encode(user.getPassword().trim()));

        iSysUsersService.saveUser(user);

        return ResultMapUtils.successResult("创建成功");
    }
}
