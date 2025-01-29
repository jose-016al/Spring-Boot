package com.example.Ejercicio4.service;

import com.example.Ejercicio4.dto.AuthResponse;
import com.example.Ejercicio4.dto.LoginRequest;
import com.example.Ejercicio4.dto.RegisterRequest;

public interface IAuthService {
    public AuthResponse login(LoginRequest request);
    public AuthResponse register(RegisterRequest request);
}
