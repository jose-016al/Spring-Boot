package com.jose.spring_secure_api.service;

import com.jose.spring_secure_api.model.User;

import java.util.Map;

public interface IJwtService {
    public String generateToken(User user, Map<String, Object> extraClaims);
    public String extractUsername(String jwt);
}
