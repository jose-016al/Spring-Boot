package com.example.Ejercicio4.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService implements IJwtService {

    private static final String SECRET_KEY = "p3PtICVJBGH45kylyB3eVW7A+Q84Mj5p+JRyIRQ8KvE=";

    @Override
    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(), user);
    }

    private String getToken(Map<String, Object> extractClaims, UserDetails user) {
        return Jwts
                .builder()
                .header()
                .type("JWT")
                .and()
                .subject(user.getUsername())
                .expiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 30))
                .issuedAt(new Date(System.currentTimeMillis()))
                .claims(extractClaims)
                .signWith(getKey(), Jwts.SIG.HS256)
                .compact();
    }

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    @Override
    public String getUsernameFromToken(String token) {
        return getClaims(token, Claims::getSubject);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Claims getAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public <T> T getClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpiration(String token) {
        return getClaims(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }
}
