package com.nutri.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private RepositoryUserDetailService userDetailService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder());
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();

        // Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/register").permitAll();
        http.authorizeRequests().antMatchers("/test").permitAll();


        // Private pages
        //administrator
        http.authorizeRequests().antMatchers("/admin").hasAnyRole("admin");

        http.authorizeRequests().antMatchers("/adminCharts").hasAnyRole("admin");
        http.authorizeRequests().antMatchers("/tablesClient").hasAnyRole("admin");
        http.authorizeRequests().antMatchers("/workerTable").hasAnyRole("admin");
        http.authorizeRequests().antMatchers("/addWorker").hasAnyRole("admin");
        http.authorizeRequests().antMatchers("/workerTable/{id}").hasAnyRole("admin");
        http.authorizeRequests().antMatchers("/workerTable/{id}/delete").hasAnyRole("admin");

        http.authorizeRequests().antMatchers("/tablesClient/{id}").hasAnyRole("admin");
        http.authorizeRequests().antMatchers("/tablesClient/{id}/delete").hasAnyRole("admin");

        //worker
        http.authorizeRequests().antMatchers("/MONschedule{id}").hasAnyRole("worker");

        http.authorizeRequests().antMatchers("/MONprofile/{id}").hasAnyRole("worker");
        http.authorizeRequests().antMatchers("/MONeditProfile").hasAnyRole("worker");
        http.authorizeRequests().antMatchers("/MONeditProfile/{id}").hasAnyRole("worker");

        http.authorizeRequests().antMatchers("/MONexerciseTable").hasAnyRole("worker");
        http.authorizeRequests().antMatchers("/MONexerciseTable/{id}").hasAnyRole("worker");

        http.authorizeRequests().antMatchers("/MONaddNewExerciseTable").hasAnyRole("worker");
        http.authorizeRequests().antMatchers("/MONeditExerciseTable/{id}").hasAnyRole("worker");

        http.authorizeRequests().antMatchers("/MONeditActivity/{id}").hasAnyRole("worker");
        http.authorizeRequests().antMatchers("/MONexerciseTable/delete/{id}").hasAnyRole("worker");

        http.authorizeRequests().antMatchers("/MONactivities").hasAnyRole("worker");
        http.authorizeRequests().antMatchers("/MONactivity/{id}").hasAnyRole("worker");
        http.authorizeRequests().antMatchers("/MONactivity/{id}/image").hasAnyRole("worker");

        //client
        http.authorizeRequests().antMatchers("/clientDiets").hasAnyRole("client");
        http.authorizeRequests().antMatchers("/clientForm").hasAnyRole("client");
        http.authorizeRequests().antMatchers("/clientRecepies").hasAnyRole("client");

        http.authorizeRequests().antMatchers("/clientChart").hasAnyRole("client");
        http.authorizeRequests().antMatchers("/clientInfo").hasAnyRole("client");
        http.authorizeRequests().antMatchers("/clientInfoSettings").hasAnyRole("client");


        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("email");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/error");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");


        }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

}
