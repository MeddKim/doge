package com.security.config;

import com.security.security.CustomAuthenticationSuccessHandler;
import com.security.security.CustomSecurityInterceptor;
import com.security.service.impl.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author: Administrator
 * @date : 2017/5/24 0024
 * @Description:
 */
@Configuration
@EnableWebSecurity //开启Spring Security功能
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                /******静态资源和首页无需权限********/
                .antMatchers("/css/**","/index").permitAll()
                /**URL以/user开头需要拥有USER角色**/
                .antMatchers("/user/**").hasRole("USER")
                .and()
                .formLogin().loginPage("/login").failureUrl("/login-error");
//        SimpleUrlAuthenticationSuccessHandler
//        http.csrf().disable();



    }

    @Bean
    public CustomSecurityInterceptor CustomSecurityInterceptor(){
        UsernamePasswordAuthenticationFil     ter
        CustomSecurityInterceptor interceptor = new CustomSecurityInterceptor();
        return interceptor;
    }

    @Bean
    public CustomAuthenticationSuccessHandler getCustomAuthenticationSuccessHandler(){
        CustomAuthenticationSuccessHandler handler = new CustomAuthenticationSuccessHandler();
        handler.setDefaultTargetUrl("/login-success");
        return handler;
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
//

        auth.userDetailsService(customUserService());

    }


}


