package com.nutri.backend.security;

import com.nutri.backend.security.jwt.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import java.security.SecureRandom;

@Configuration
@Order(1)
public class RestSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    RepositoryUserDetailService userDetailsService;

    @Autowired
    JwtRequestFilter jwtRequestFilter;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.antMatcher("/api/**");
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/users/me").hasAnyRole("worker","client");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/users/me").hasAnyRole("worker","client");
        //admin URLs
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/users").hasRole("admin");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/users/{id}").hasRole("admin");
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/users/workers/").hasRole("admin");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/users/admin/stats/users").hasRole("admin");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/users/admin/stats/diets").hasRole("admin");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/users/admin/stats/earns").hasRole("admin");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/users/{id}").hasRole("admin");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/users").hasRole("admin");
        //Client URL
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/users/me/recepies").hasRole("client");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/users/me/diets").hasRole("client");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/users/me/stats").hasRole("client");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/forms/me").hasRole("client");
        //Worker URL
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/recepies").hasRole("worker");
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/recepies/").hasRole("worker");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/diets").hasRole("worker");
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/diets/").hasRole("worker");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/diets").hasRole("worker");
        //Personal Info


        http.authorizeRequests().anyRequest().permitAll();

        // Disable CSRF protection (it is difficult to implement in REST APIs)
        http.csrf().disable();

        // Disable Http Basic Authentication
        http.httpBasic().disable();

        // Disable Form login Authentication
        http.formLogin().disable();

        // Avoid creating session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add JWT Token filter
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }

}
