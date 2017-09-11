package com.auth.config;

import com.auth.service.impl.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author: Administrator
 * @date : 2017/5/24 0024
 * @Description:
 */
@EnableWebSecurity //开启Spring Security功能
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                /******静态资源和首页无需权限********/
                .antMatchers("/css/**","/index").permitAll()
                /**URL以/user开头需要拥有USER角色**/
//                .antMatchers("/user/**").hasRole("USER")
                //.antMatchers("/user/**").hasRole("USER")
                .antMatchers("/user/**").authenticated()
                .and()
                .formLogin().loginPage("/login").failureUrl("/login-error");

    }

    @Bean
    UserDetailsService customUserService(){
        return new CustomUserService();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");


        auth.userDetailsService(customUserService());

    }

}


