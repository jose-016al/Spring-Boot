package com.example.clinca_odontologica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(HttpMethod.GET, "/pacientes").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/dentistas").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/turnos").permitAll();

                    auth.requestMatchers("/doc/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll();

                    auth.anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults()) // Autenticación por formulario
                .httpBasic(Customizer.withDefaults()) // Autenticación básica
                .build();
    }
}
