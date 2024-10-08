package com.agcodes.spring_security_jpa;

import static org.springframework.security.config.Customizer.withDefaults;

import com.agcodes.spring_security_jpa.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
  @Autowired
  AppUserDetailsService userDetailsService;
  @Autowired
  public void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.userDetailsService(userDetailsService);
  }

  @Bean
  public PasswordEncoder passwordEncoder(){
    return NoOpPasswordEncoder.getInstance();
  }

    @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

    http
        .csrf(csrf->csrf.disable()) // Disable CSRF if your API is stateless
        .authorizeRequests(
        authorize -> authorize
            .requestMatchers("/admin").hasRole("ADMIN")
            .requestMatchers("/api/v1/users/**").hasAnyRole("ADMIN")  // Admins access
            .requestMatchers("/user").hasAnyRole("USER", "ADMIN")
            .requestMatchers("/login").permitAll()
            .requestMatchers("/").permitAll()
        )
        .formLogin(withDefaults());

    return http.build();

}
}
