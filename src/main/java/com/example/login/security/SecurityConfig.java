package com.example.login.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())               // 关闭 CSRF，方便 Postman/Cypress
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll() // 放行所有 /api 接口
                        .anyRequest().permitAll()
                );
        return http.build();
    }
}

