package com.jose.spring_secure_api.service;

import com.jose.spring_secure_api.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

/**
 * JwtService es un servicio que se encarga de generar y extraer tokens JWT (JSON Web Tokens)
 * para la autenticación y autorización de usuarios. Utiliza una clave secreta para firmar y verificar
 * los tokens y gestiona su caducidad.
 */
@Service
public class JwtService implements IJwtService {

    @Value("${security.jwt.expiration-days}")
    private Long EXPIRATION_DAYS;

    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;

    /**
     * Genera un token JWT para un usuario específico, con una fecha de expiración configurada.
     *
     * @param user El usuario para el cual se genera el token.
     * @param extraClaims Cláusulas adicionales que se incluyen en el token.
     * @return El token JWT generado.
     */
    @Override
    public String generateToken(User user, Map<String, Object> extraClaims) {
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date(issuedAt.getTime() + (EXPIRATION_DAYS * 24 * 60 * 60 * 1000));

        return Jwts.builder()
                .header()
                .type("JWT")
                .and()
                .claims(extraClaims)
                .subject(user.getUsername())
                .issuedAt(issuedAt)
                .expiration(expiration)
                .signWith(generateKey(), Jwts.SIG.HS256)
                .compact();
    }

    /**
     * Genera la clave secreta a partir de la clave configurada en las propiedades de la aplicación.
     *
     * @return La clave secreta utilizada para firmar y verificar el token.
     */
    private SecretKey generateKey() {
        byte[] secretAsBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(secretAsBytes);
    }

    /**
     * Extrae el nombre de usuario desde un token JWT.
     *
     * @param jwt El token JWT del cual extraer el nombre de usuario.
     * @return El nombre de usuario contenido en el token.
     */
    @Override
    public String extractUsername(String jwt) {
        return extractAllClaims(jwt).getSubject();
    }

    /**
     * Extrae todas las reclamaciones (claims) de un token JWT.
     *
     * @param jwt El token JWT del cual extraer las reclamaciones.
     * @return Las reclamaciones extraídas del token.
     */
    private Claims extractAllClaims(String jwt) {
        return Jwts.parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }
}
