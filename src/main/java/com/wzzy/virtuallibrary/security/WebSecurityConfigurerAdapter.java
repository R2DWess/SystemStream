package com.wzzy.virtuallibrary.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public abstract class WebSecurityConfigurerAdapter {


    private AuthenticationManager authenticationManager;

    protected abstract void configure(AuthenticationManagerBuilder auth) throws Exception;

    protected abstract void configure(HttpSecurity http) throws Exception;

    protected AuthenticationManager authenticationManagerBean() throws Exception {
        return authenticationManager;
    }
}