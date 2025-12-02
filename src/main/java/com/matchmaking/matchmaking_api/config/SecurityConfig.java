package com.matchmaking.matchmaking_api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())            // desabilita CSRF (para Postman e Flutter)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()        // libera tudo
                );

        return http.build();
    }
}