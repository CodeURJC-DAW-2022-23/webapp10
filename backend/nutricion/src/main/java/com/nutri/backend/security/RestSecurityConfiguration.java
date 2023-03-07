package com.nutri.backend.security;

import com.nutri.backend.security.jwt.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Order(1)
public class RestSecurityConfiguration {

    @Autowired
    RepositoryUserDetailService userDetailsService;

    @Autowired
    JwtRequestFilter jwtRequestFilter;

    @Autowired
    public PasswordEncoder passwordEncoder;
}
