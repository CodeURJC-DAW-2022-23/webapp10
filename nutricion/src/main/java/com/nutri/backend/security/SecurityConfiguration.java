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
            http.authorizeRequests().antMatchers("/admin").authenticated();

            http.authorizeRequests().antMatchers("/adminCharts").hasAnyRole("ADMIN");
            http.authorizeRequests().antMatchers("/tablesClient").hasAnyRole("ADMIN");
            http.authorizeRequests().antMatchers("/workerTable").hasAnyRole("ADMIN");
            http.authorizeRequests().antMatchers("/addWorker").hasAnyRole("ADMIN");
            http.authorizeRequests().antMatchers("/workerTable/{id}").hasAnyRole("ADMIN");
            http.authorizeRequests().antMatchers("/workerTable/{id}/delete").hasAnyRole("ADMIN");

            http.authorizeRequests().antMatchers("/tablesClient/{id}").hasAnyRole("ADMIN");
            http.authorizeRequests().antMatchers("/tablesClient/{id}/delete").hasAnyRole("ADMIN");

            //worker
            http.authorizeRequests().antMatchers("/MONschedule{id}").hasAnyRole("WORKER");

            http.authorizeRequests().antMatchers("/MONprofile/{id}").hasAnyRole("WORKER");
            http.authorizeRequests().antMatchers("/MONeditProfile").hasAnyRole("WORKER");
            http.authorizeRequests().antMatchers("/MONeditProfile/{id}").hasAnyRole("WORKER");

            http.authorizeRequests().antMatchers("/MONexerciseTable").hasAnyRole("WORKER");
            http.authorizeRequests().antMatchers("/MONexerciseTable/{id}").hasAnyRole("WORKER");

            http.authorizeRequests().antMatchers("/MONaddNewExerciseTable").hasAnyRole("WORKER");
            http.authorizeRequests().antMatchers("/MONeditExerciseTable/{id}").hasAnyRole("WORKER");

            http.authorizeRequests().antMatchers("/MONeditActivity/{id}").hasAnyRole("WORKER");
            http.authorizeRequests().antMatchers("/MONexerciseTable/delete/{id}").hasAnyRole("WORKER");

            http.authorizeRequests().antMatchers("/MONactivities").hasAnyRole("WORKER");
            http.authorizeRequests().antMatchers("/MONactivity/{id}").hasAnyRole("WORKER");
            http.authorizeRequests().antMatchers("/MONactivity/{id}/image").hasAnyRole("WORKER");

            //client
            http.authorizeRequests().antMatchers("/clientDiets").hasAnyRole("CLIENT");
            http.authorizeRequests().antMatchers("/clientForm").hasAnyRole("CLIENT");
            http.authorizeRequests().antMatchers("/clientRecepies").hasAnyRole("CLIENT");

            http.authorizeRequests().antMatchers("/clientChart").hasAnyRole("CLIENT");
            http.authorizeRequests().antMatchers("/clientInfo").hasAnyRole("CLIENT");
            http.authorizeRequests().antMatchers("/clientInfoSettings").hasAnyRole("CLIENT");




            // Login form
            http.formLogin().loginPage("/login");
            http.formLogin().usernameParameter("email");
            http.formLogin().passwordParameter("password");
            http.formLogin().defaultSuccessUrl("/admin");
            http.formLogin().failureUrl("/");

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
