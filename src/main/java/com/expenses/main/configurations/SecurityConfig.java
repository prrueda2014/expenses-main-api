package com.expenses.main.configurations;

import com.expenses.main.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    UserRepository userRepository;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> auth.requestMatchers("/admin/*")
                        .hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(formLogin -> formLogin.permitAll())
                .logout(logout -> logout.permitAll());
        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetailsService userDetail = username -> userRepository.findByUsername(username)
                .map(myUser -> User.builder()
                        .username(myUser.getUsername())
                        .password(myUser.getPassword())
                        .roles(String.valueOf(myUser.getRole())).build())
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        return userDetail;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
