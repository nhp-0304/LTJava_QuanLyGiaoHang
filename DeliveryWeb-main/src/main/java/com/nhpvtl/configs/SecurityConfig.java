/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nhpvtl.handlers.LoginHandler;
import com.nhpvtl.handlers.LogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author DELL
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.nhpvtl.controllers",
    "com.nhpvtl.repository",
    "com.nhpvtl.service",
    "com.nhpvtl.handlers"
})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private LoginHandler loginHandler;

    @Autowired
    private LogoutHandler logoutHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").usernameParameter("userName").passwordParameter("password");

        http.formLogin().successHandler(this.loginHandler);

//        http.formLogin().defaultSuccessUrl("/").failureUrl("/login?error");
//        http.logout().logoutSuccessUrl("/login");
        http.logout().logoutSuccessHandler(this.logoutHandler);

        http.exceptionHandling().accessDeniedPage("/login?accessDenied");

        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/**/admin/**")
                .access("hasRole('ROLE_ADMIN')");

        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/**/customer/**")
                .access("hasRole('ROLE_CUSTOMER')");

        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/**/shipper/**")
                .access("hasRole('ROLE_SHIPPER')");

        http.csrf().disable();
    }

//    LenVo
    @Bean
    public Cloudinary cloudinary() {
        Cloudinary c = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "lenvo1202",
                        "api_key", "493287268151437",
                        "api_secret", "nMqfQqWtd7VFbrYFC8YmNK-9X4o",
                        "secure", true));
        return c;
    }
}
