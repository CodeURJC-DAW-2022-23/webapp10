package com.nutri.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
        http.authorizeRequests().antMatchers("/workerDiets").hasAnyRole("worker");
        http.authorizeRequests().antMatchers("/workerUploadDiets").hasAnyRole("worker");
        http.authorizeRequests().antMatchers("/workerUploadRecipes").hasAnyRole("worker");
        http.authorizeRequests().antMatchers("/workerProfile").hasAnyRole("worker");
        http.authorizeRequests().antMatchers("/viewDiet").hasAnyRole("worker");
        http.authorizeRequests().antMatchers("/viewRecipe").hasAnyRole("worker");
        //http.authorizeRequests().antMatchers("/deleteDiet").hasAnyRole("worker");

        //client
        http.authorizeRequests().antMatchers("/clientDiets").hasAnyRole("client");
        http.authorizeRequests().antMatchers("/clientForm").hasAnyRole("client");
        http.authorizeRequests().antMatchers("/clientRecepies").hasAnyRole("client");

        http.authorizeRequests().antMatchers("/clientChart").hasAnyRole("client");
        http.authorizeRequests().antMatchers("/clientInfo").hasAnyRole("client");
        http.authorizeRequests().antMatchers("/clientInfoSettings").hasAnyRole("client");
        http.authorizeRequests().antMatchers("/clientProfile").hasAnyRole("client");

        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("email");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/loginError");

        // Logout

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"));
        http.logout().logoutSuccessUrl("/");




    }
}
