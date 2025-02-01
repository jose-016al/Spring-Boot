package com.jose.spring_secure_api.service;

import com.jose.spring_secure_api.dto.AuthRequestDTO;
import com.jose.spring_secure_api.dto.AuthResponseDTO;
import com.jose.spring_secure_api.dto.RegisterRequestDTO;
import com.jose.spring_secure_api.exception.AuthenticationException;
import com.jose.spring_secure_api.exception.UserAlreadyExistsException;
import com.jose.spring_secure_api.model.User;
import com.jose.spring_secure_api.repository.UserRepository;
import com.jose.spring_secure_api.util.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * AuthService es un servicio que gestiona las operaciones relacionadas con la autenticación y el registro de usuarios.
 * Permite a los usuarios iniciar sesión y registrarse, generando un token JWT para la autenticación.
 */
@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final IJwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    /**
     * Realiza el inicio de sesión de un usuario, validando sus credenciales y generando un token JWT.
     *
     * @param request El DTO que contiene las credenciales del usuario (nombre de usuario y contraseña).
     * @return Un DTO de respuesta que contiene el token JWT generado.
     * @throws AuthenticationException Si las credenciales son incorrectas.
     */
    @Override
    public AuthResponseDTO login(AuthRequestDTO request) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()
        );
        try {
            authenticationManager.authenticate(authToken);
        } catch (BadCredentialsException e) {
                // Lanza una excepción personalizada si las credenciales son incorrectas
            throw new AuthenticationException("Error de autenticación");
        }

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AuthenticationException("Error de autenticación"));

            // Generar el token JWT si el usuario existe
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));

        return AuthResponseDTO.builder()
                .jwt(jwt)
                .build();
    }

    /**
     * Registra un nuevo usuario en el sistema si no existe uno con el mismo nombre de usuario.
     *
     * @param request El DTO que contiene la información del nuevo usuario.
     * @throws UserAlreadyExistsException Si el usuario ya existe en la base de datos.
     */
    @Override
    public void register(RegisterRequestDTO request) {
        Optional<User> userOptional = userRepository.findByUsername(request.getUsername());
            // Si el usuario ya existe, lanza una excepción
        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException("El usuario ya existe");
        } else {
                // Si el usuario no existe, lo guarda en la base de datos
            userRepository.save(User.builder()
                    .username(request.getUsername())
                    .name(request.getName())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.CUSTOMER)
                    .build()
            );
        }
    }

    /**
     * Genera una colección de reclamaciones (claims) adicionales para incluir en el token JWT.
     *
     * @param user El usuario para el cual se generan las reclamaciones.
     * @return Un mapa con las reclamaciones adicionales.
     */
    private Map<String, Object> generateExtraClaims(User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getName());
        extraClaims.put("role", user.getRole().name());
        extraClaims.put("permissions", user.getAuthorities());
        return extraClaims;
    }
}
