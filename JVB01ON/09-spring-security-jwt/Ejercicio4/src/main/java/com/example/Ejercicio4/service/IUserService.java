package com.example.Ejercicio4.service;

import com.example.Ejercicio4.dto.UserResponse;
import com.example.Ejercicio4.model.User;

import java.util.List;

public interface IUserService {
    public List<UserResponse> findAll();
    public UserResponse findById(Long id);
    public boolean delete(Long id);
    public UserResponse update(Long id, String name, String surname, String email);
}