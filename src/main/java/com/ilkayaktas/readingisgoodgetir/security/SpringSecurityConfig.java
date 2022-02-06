package com.ilkayaktas.readingisgoodgetir.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   private UserService userService;

   @Autowired
   private PasswordEncoder passwordEncoder;

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
   }

   // Secure the endpoins with HTTP Basic authentication
   @Override
   protected void configure(HttpSecurity http) throws Exception {

      http
              //HTTP Basic authentication
              .httpBasic()
              .and()
              .authorizeRequests()
              .anyRequest()
              .authenticated()
              .and()
              .csrf().disable()
              .formLogin().disable();
   }


   @Bean
   PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }


}
