package com.auth.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class RootController {

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
}
