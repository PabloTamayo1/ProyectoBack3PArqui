package com.banquito.banquito.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desactiva CSRF para las pruebas
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/api/usuarios/**", "/api/solicitudes/**", "/api/documentos/**", "/api/historiales/**","/api/transacciones/**","/api/logs/**","/api/graphql/**").permitAll()
                .requestMatchers("/graphql").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(); // Usar autenticación básica si es necesario

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            throw new UsernameNotFoundException("User not found");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
