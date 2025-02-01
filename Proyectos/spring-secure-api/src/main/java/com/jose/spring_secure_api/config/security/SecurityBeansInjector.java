package com.jose.spring_secure_api.config.security;

import com.jose.spring_secure_api.exception.AuthenticationException;
import com.jose.spring_secure_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * SecurityBeansInjector es una clase de configuración que define los beans necesarios
 * para la autenticación y la gestión de la seguridad en la aplicación. Configura el
 * proveedor de autenticación, el codificador de contraseñas y el servicio de detalles de usuario.
 */
@Component
@RequiredArgsConstructor
public class SecurityBeansInjector {

    private final UserRepository userRepository;

    /**
     * Configura y proporciona el AuthenticationManager para gestionar la autenticación de los usuarios.
     *
     * @param authenticationConfiguration Configuración de autenticación de Spring Security.
     * @return El AuthenticationManager configurado.
     * @throws Exception Si ocurre un error durante la configuración.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * Configura y proporciona un AuthenticationProvider que utiliza un DaoAuthenticationProvider
     * para autenticar a los usuarios mediante sus detalles almacenados en la base de datos.
     *
     * @return El AuthenticationProvider configurado.
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    /**
     * Configura y proporciona un PasswordEncoder para codificar y comparar contraseñas.
     * Utiliza BCrypt para codificar las contraseñas de manera segura.
     *
     * @return El PasswordEncoder configurado.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configura y proporciona un UserDetailsService que carga los detalles del usuario desde la base de datos.
     * Si no se encuentra un usuario con el nombre de usuario proporcionado, lanza una excepción de autenticación.
     *
     * @return El UserDetailsService configurado.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByUsername(username)
                .orElseThrow(() -> new AuthenticationException("Error de autenticación"));
    }
}
