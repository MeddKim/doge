package com.auth.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        if(request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)
                || request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)){

            ObjectMapper mapper = new ObjectMapper();
            UsernamePasswordAuthenticationToken authRequest = null;
            try{
                InputStream is = request.getInputStream();
                AuthenticationBean authenticationBean = mapper.readValue(is,AuthenticationBean.class);
                authRequest = new UsernamePasswordAuthenticationToken(
                        authenticationBean.getUsername(), authenticationBean.getPassword());
            }catch (Exception e){
                e.printStackTrace();
                authRequest = new UsernamePasswordAuthenticationToken(
                        "", "");
            }finally {
                setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            }
        }else{
            return super.attemptAuthentication(request, response);
        }
    }
}
