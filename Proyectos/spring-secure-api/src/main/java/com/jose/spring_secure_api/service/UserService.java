package com.jose.spring_secure_api.service;

import com.jose.spring_secure_api.dto.UserResponseDTO;
import com.jose.spring_secure_api.model.User;
import com.jose.spring_secure_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final IJwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream()
                .map(user -> UserResponseDTO.builder()
                        .username(user.getUsername())
                        .name(user.getName())
                        .build()
                )
                .toList();
    }

    @Override
    public UserResponseDTO findMyUser() {
        return UserResponseDTO.builder()
                .username(authenticatedUser().getUsername())
                .name(authenticatedUser().getName())
                .build();
    }

    /**
     * Obtiene el usuario que está autenticado en el contexto de seguridad de Spring Security.
     *
     * @return El objeto {@link User} que representa al usuario autenticado.
     */
    private User authenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (User) auth.getPrincipal();
    }
}
