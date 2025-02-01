package com.jose.spring_secure_api.service;

import com.jose.spring_secure_api.dto.AuthRequestDTO;
import com.jose.spring_secure_api.dto.AuthResponseDTO;
import com.jose.spring_secure_api.dto.RegisterRequestDTO;
import jakarta.validation.Valid;

public interface IAuthService {
    public AuthResponseDTO login(AuthRequestDTO request);
    public void register(RegisterRequestDTO request);
}
