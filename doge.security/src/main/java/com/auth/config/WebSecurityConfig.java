package com.auth.config;

import com.auth.security.CustomAuthenticationEntryPoint;
import com.auth.security.CustomAuthenticationFailureHandler;
import com.auth.security.CustomAuthenticationFilter;
import com.auth.security.CustomAuthenticationSuccessHandler;
import com.auth.service.impl.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
                .antMatchers("/user/**").authenticated()
                .and()
                .formLogin().loginPage("/login").failureUrl("/login-error")

                //设置未登录时的提示信息
                .and().exceptionHandling()
                .authenticationEntryPoint(customAuthenticationEntryPoint()).and()
                .httpBasic();

        //关闭csrf
        http.addFilterAt(customAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter.class).csrf().disable();

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

    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter()throws Exception{
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(new CustomAuthenticationSuccessHandler());
        filter.setAuthenticationFailureHandler(new CustomAuthenticationFailureHandler());
//        filter.setAuthenticationFailureHandler(new FailureHandler());
//        filter.setFilterProcessesUrl("/login/self");
        //这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    @Bean
    public CustomAuthenticationEntryPoint customAuthenticationEntryPoint(){
        return new CustomAuthenticationEntryPoint();
    }
}


