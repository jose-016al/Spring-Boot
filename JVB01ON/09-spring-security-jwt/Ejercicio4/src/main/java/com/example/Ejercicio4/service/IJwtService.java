package com.example.Ejercicio4.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {
    public String getToken(UserDetails user);
    public String getUsernameFromToken(String token);
    public boolean isTokenValid(String token, UserDetails userDetails);
}
