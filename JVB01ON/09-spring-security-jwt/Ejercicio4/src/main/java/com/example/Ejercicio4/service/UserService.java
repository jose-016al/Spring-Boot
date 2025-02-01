package com.example.Ejercicio4.service;

import com.example.Ejercicio4.dto.UserResponse;
import com.example.Ejercicio4.model.User;
import com.example.Ejercicio4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository repository;

    @Override
    public List<UserResponse> findAll() {
        return repository.findAll().stream()
                .map(user -> UserResponse.builder()
                        .email(user.getEmail())
                        .name(user.getName())
                        .surname(user.getSurname())
                        .build()
                )
                .toList();
    }

    @Override
    public UserResponse findById(Long id) {
        return repository.findById(id)
                .map(user -> UserResponse.builder()
                        .email(user.getEmail())
                        .name(user.getName())
                        .surname(user.getSurname())
                        .build()
                )
                .orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserResponse update(Long id, String email, String name, String surname) {
        Optional<User> optionalUser = repository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEmail(email);
            user.setName(name);
            user.setSurname(surname);

            repository.save(user);

            return UserResponse.builder()
                    .email(user.getEmail())
                    .name(user.getName())
                    .surname(user.getSurname())
                    .build();
        } else {
            return null;
        }
    }
}
