package com.example.backend.DTO;

import com.example.backend.Entity.User;

public record UserResponseDTO(
        Long id,
        String firstName,
        String email,
        String phone,
        String sexo) {
    public UserResponseDTO(User user) {
        this(user.getId() , user.getFirstName(), user.getEmail(), user.getPhone(), user.getSexo());
    };
}
