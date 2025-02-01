package com.jose.spring_secure_api.config.security.filter;

import com.jose.spring_secure_api.model.User;
import com.jose.spring_secure_api.repository.UserRepository;
import com.jose.spring_secure_api.service.IJwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * JwtAuthenticationFilter es un filtro responsable de procesar las solicitudes HTTP entrantes
 * para validar y autenticar los tokens JWT. Intercepta cada solicitud y verifica la presencia
 * y validez de un token JWT en el encabezado "Authorization". Si el token es válido, el usuario es autenticado
 * y el contexto de seguridad se actualiza con los detalles del usuario.
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final IJwtService jwtService;
    private final UserRepository userRepository;

    /**
     * Procesa la solicitud HTTP entrante para validar el token JWT y autenticar al usuario.
     * Si el token es válido, se recuperan los detalles del usuario y se configura la autenticación en el contexto de seguridad.
     * Si el token falta o es inválido, la solicitud continúa sin autenticación.
     *
     * @param request La solicitud HTTP.
     * @param response La respuesta HTTP.
     * @param filterChain La cadena de filtros para pasar la solicitud y la respuesta.
     * @throws ServletException Si ocurre un error durante el procesamiento de la solicitud.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

            // Recuperar el encabezado "Authorization" de la solicitud
        String authHeader = request.getHeader("Authorization");

            // Si el encabezado es nulo o no comienza con "Bearer ", se omite este filtro
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        try {
                // Extraer el token JWT del encabezado "Authorization"
            String jwt = authHeader.split(" ")[1];

                // Extraer el nombre de usuario del token JWT
            String username = jwtService.extractUsername(jwt);

                // Si el nombre de usuario es nulo o el usuario ya está autenticado, enviar una respuesta de error
            if (username == null || SecurityContextHolder.getContext().getAuthentication() != null) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or missing token");
                return;
            }
                // Buscar al usuario en la base de datos por su nombre de usuario
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found"));

                // Crear un objeto de autenticación con los detalles del usuario
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    user, null, user.getAuthorities()
            );

                // Establecer la autenticación en el contexto de seguridad
            SecurityContextHolder.getContext().setAuthentication(authToken);

        } catch (Exception e) {
                // Si ocurre algún error, enviar una respuesta de error de autenticación
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
