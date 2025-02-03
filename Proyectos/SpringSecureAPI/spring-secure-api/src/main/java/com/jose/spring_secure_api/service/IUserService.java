package com.jose.spring_secure_api.service;

import com.jose.spring_secure_api.dto.UserResponseDTO;

import java.util.List;

public interface IUserService {
    public List<UserResponseDTO> findAll();
    public UserResponseDTO findMyUser();
}
