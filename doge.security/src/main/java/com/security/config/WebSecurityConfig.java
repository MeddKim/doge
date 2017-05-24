package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author: Administrator
 * @date : 2017/5/24 0024
 * @Description:
 */
@Configuration
@EnableWebSecurity //开启Spring Security功能
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
        //允许所有用户访问"/"和"/home"
        http.authorizeRequests().antMatchers("/","/home").permitAll()
                //其他地址访问需要权限验证
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //指定登陆页为"/login"
                .loginPage("/")
                .defaultSuccessUrl("/hello") //登陆成功后调整到"/hello"
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/home") //退出登陆后跳转url为"/home"
                .permitAll();
         **/

        /**
         * configure(HttpSecurity http) 方法
         *  通过 authorizeRequests() 定义哪些URL需要被保护、哪些不需要被保护。
         *  例如以上代码指定了 / 和 /home 不需要任何认证就可以访问，其他的路径都必须通过身份验证
         *  通过 formLogin() 定义当需要用户登录时候，转到的登录页面。
         */
        http.authorizeRequests()
                .antMatchers("/","/home.html","/home").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll();
    }

    /**
     * configureGlobal(AuthenticationManagerBuilder auth) 方法，
     * 在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER。
     * @param auth
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService()
//                .passwordEncoder(passwordEncoder());
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
    }

    /**
     * 设置用户密码的加密方式为MD5
     */

    @Bean
    public Md5PasswordEncoder passwordEncoder(){
        return new Md5PasswordEncoder();
    }

    /**
     * 自定义UserDetailService，从数据库中读取用户信息
     */

}


