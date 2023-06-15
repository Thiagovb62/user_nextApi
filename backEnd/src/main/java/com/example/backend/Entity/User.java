package com.example.backend.Entity;

import com.example.backend.DTO.UserRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;


@Table(name = "User_Table")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Long id;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "sexo")
    private String sexo;

    public User(UserRequestDTO userRequestDTO) {
        this.firstName = userRequestDTO.firstName();
        this.email = userRequestDTO.email();
        this.phone = userRequestDTO.phone();
        this.sexo = userRequestDTO.sexo();
    }
}