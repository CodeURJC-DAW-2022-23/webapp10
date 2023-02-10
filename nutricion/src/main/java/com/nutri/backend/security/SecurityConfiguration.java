package com.nutri.backend.security;

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

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
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
            http.authorizeRequests().antMatchers("/admin").hasAnyRole("administrator");

            http.authorizeRequests().antMatchers("/adminCharts").hasAnyRole("administrator");
            http.authorizeRequests().antMatchers("/tablesClient").hasAnyRole("administrator");
            http.authorizeRequests().antMatchers("/workerTable").hasAnyRole("administrator");
            http.authorizeRequests().antMatchers("/addWorker").hasAnyRole("administrator");
            http.authorizeRequests().antMatchers("/workerTable/{id}").hasAnyRole("administrator");
            http.authorizeRequests().antMatchers("/workerTable/{id}/delete").hasAnyRole("administrator");

            http.authorizeRequests().antMatchers("/tablesClient/{id}").hasAnyRole("administrator");
            http.authorizeRequests().antMatchers("/tablesClient/{id}/delete").hasAnyRole("administrator");

            //monitor
            http.authorizeRequests().antMatchers("/MONschedule{id}").hasAnyRole("monitor");

            http.authorizeRequests().antMatchers("/MONprofile/{id}").hasAnyRole("monitor");
            http.authorizeRequests().antMatchers("/MONeditProfile").hasAnyRole("monitor");
            http.authorizeRequests().antMatchers("/MONeditProfile/{id}").hasAnyRole("monitor");

            http.authorizeRequests().antMatchers("/MONexerciseTable").hasAnyRole("monitor");
            http.authorizeRequests().antMatchers("/MONexerciseTable/{id}").hasAnyRole("monitor");

            http.authorizeRequests().antMatchers("/MONaddNewExerciseTable").hasAnyRole("monitor");
            http.authorizeRequests().antMatchers("/MONeditExerciseTable/{id}").hasAnyRole("monitor");

            http.authorizeRequests().antMatchers("/MONeditActivity/{id}").hasAnyRole("monitor");
            http.authorizeRequests().antMatchers("/MONexerciseTable/delete/{id}").hasAnyRole("monitor");

            http.authorizeRequests().antMatchers("/MONactivities").hasAnyRole("monitor");
            http.authorizeRequests().antMatchers("/MONactivity/{id}").hasAnyRole("monitor");
            http.authorizeRequests().antMatchers("/MONactivity/{id}/image").hasAnyRole("monitor");

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
            http.formLogin().defaultSuccessUrl("/private");
            http.formLogin().failureUrl("/login");

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
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


    }
}
