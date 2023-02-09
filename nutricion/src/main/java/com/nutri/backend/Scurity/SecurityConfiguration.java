package com.nutri.backend.Scurity;

import com.nutri.backend.repositories.RepositoryUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    public RepositoryUserDetailsService userDetailService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin").authenticated();
        http.authorizeRequests().antMatchers("/cliente").authenticated();
        http.authorizeRequests().antMatchers("/worker").authenticated();
        // Private pages (all other pages)
        http.authorizeRequests().anyRequest().permitAll();
        //Configuramos las URLs que puede ver cada
        //tipo de usuario
        http.authorizeRequests().antMatchers("/cliente").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");
        // Security configuration
        // - Public and private pages
        // - Login and logout
        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/cliente");
        http.formLogin().failureUrl("/404");
        // LogOut form
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");


        // - Other security configurations
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder());

        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();

        String encodedPassword = encoder.encode("pass");

        auth.inMemoryAuthentication()
                .withUser("user").password(encoder.encode("pass"))
                .roles("USER");

        auth.inMemoryAuthentication()
                .withUser("admin").password(encoder.encode("adminpass"))
                .roles("USER", "ADMIN");
    }
}
