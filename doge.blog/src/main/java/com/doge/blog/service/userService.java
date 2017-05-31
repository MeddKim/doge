package com.doge.blog.service;

import com.doge.blog.domain.User;

/**
 * @author: Administrator
 * @date : 2017/5/31 0031
 * @Description:
 */
public interface userService {

    boolean login(String name,String password);

    boolean addUser(User user);

}
