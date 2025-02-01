package com.example.Ejercicio4.jwt;

import com.example.Ejercicio4.service.IJwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final IJwtService jwtService;
    private final UserDetailsService userDetailsService;

    /**
     * Filtro que se ejecuta en cada petición para validar el JWT.
     * Si el token es válido, se establece la autenticación en el contexto de seguridad.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Extraer el token del encabezado de la petición
        final String token = getTokenFromRequest(request);

        // Si no hay token, devolver 401 y detener la ejecución
        if (token == null) {
            // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token is missing");
            filterChain.doFilter(request, response);
            return;
        }

        // Extraer el nombre de usuario del token
        final String username = jwtService.getUsernameFromToken(token);

        // Validar el usuario y asegurarse de que no haya autenticación previa
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // Verificar si el token es válido
            if (jwtService.isTokenValid(token, userDetails)) {
                // Crear el objeto de autenticación
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );

                // Asociar detalles adicionales de la solicitud
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Establecer la autenticación en el contexto de seguridad
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                // Si el token es inválido, devolver 401 y detener la ejecución
                // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
                filterChain.doFilter(request, response);
                return;
            }
        }

        // Continuar con la ejecución de los demás filtros
        filterChain.doFilter(request, response);
    }

    /**
     * Extrae el token JWT desde el encabezado Authorization de la petición.
     * Retorna null si el encabezado es inexistente o no tiene el formato adecuado.
     */
    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (!StringUtils.hasText(authHeader) || !authHeader.startsWith("Bearer ")) {
            return null;
        }

        return authHeader.substring(7).trim(); // Extrae y limpia el token
    }
}
