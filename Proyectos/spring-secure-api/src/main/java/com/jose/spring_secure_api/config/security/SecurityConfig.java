package com.jose.spring_secure_api.config.security;

import com.jose.spring_secure_api.config.security.filter.JwtAuthenticationFilter;
import com.jose.spring_secure_api.util.Permission;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * SecurityConfig es una clase de configuración que gestiona la seguridad web de la aplicación.
 * Configura los filtros de autenticación, las políticas de sesión y las rutas de acceso a la API.
 * Define qué rutas son públicas y cuáles están protegidas, además de configurar el uso de JWT para la autenticación.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    /**
     * Configura la cadena de filtros de seguridad para la aplicación.
     * Deshabilita la protección CSRF, establece la política de sesiones como sin estado (stateless),
     * y define las rutas públicas y privadas según los permisos requeridos.
     *
     * @param http La configuración de seguridad HTTP.
     * @return La configuración del SecurityFilterChain.
     * @throws Exception Si ocurre un error durante la configuración.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                    // Deshabilitar la protección CSRF ya que se utilizará JWT para la autenticación
                .csrf(AbstractHttpConfigurer::disable)
                    // Configuración para que las sesiones no sean almacenadas (stateless)
                .sessionManagement(sessionMangConfig ->
                        sessionMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                    // Añadir el proveedor de autenticación configurado previamente
                .authenticationProvider(authenticationProvider)
                    // Añadir el filtro de autenticación JWT antes del filtro de autenticación de nombre de usuario y contraseña
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authConfig -> {
                        // Rutas públicas (sin necesidad de autenticación)
                    authConfig.requestMatchers(HttpMethod.POST, "/auth/login").permitAll();
                    authConfig.requestMatchers(HttpMethod.POST, "/auth/register").permitAll();
                    authConfig.requestMatchers("/doc/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll();
                    // authConfig.requestMatchers("/error").permitAll();

                        // Rutas privadas (requieren permisos específicos)
                    authConfig.requestMatchers(HttpMethod.GET,"/products").hasAuthority(Permission.READ_ALL_PRODUCTS.name());
                    authConfig.requestMatchers(HttpMethod.POST,"/products").hasAuthority(Permission.SAVE_ONE_PRODUCT.name());

                    authConfig.requestMatchers(HttpMethod.GET,"/users").hasAuthority(Permission.READ_ALL_USERS.name());
                    authConfig.requestMatchers(HttpMethod.GET,"/users/me").hasAuthority(Permission.READ_MY_USER.name());

                        // Denegar el acceso al resto de las rutas
                    authConfig.anyRequest().denyAll();
                })
                .build();
    }
}
