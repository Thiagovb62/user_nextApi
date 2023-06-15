package com.example.backend.Service;

import com.example.backend.DTO.UserRequestDTO;
import com.example.backend.DTO.UserResponseDTO;
import com.example.backend.Entity.User;
import com.example.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserResponseDTO> findAll() {
        List<User> employees = userRepository.findAll();
        return employees.stream().map(UserResponseDTO::new).collect(Collectors.toList());
    }
    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow( () -> new RuntimeException("User not found"));
        return new UserResponseDTO(user);
    }
    public UserRequestDTO save(UserRequestDTO userRequestDTO) {
        User user = new User(userRequestDTO);
        userRepository.save(user);
        return userRequestDTO;
    }
    public UserRequestDTO update(Long id,UserRequestDTO userRequestDTO) {
        User user = new User(userRequestDTO);
        User userCheck = userRepository.findById(id).orElseThrow( () -> new RuntimeException("User not found"));
        userCheck.setFirstName(user.getFirstName());
        userCheck.setEmail(user.getEmail());
        userCheck.setPhone(user.getPhone());
        userCheck.setSexo(user.getSexo());
        userRepository.save(userCheck);
        return userRequestDTO;
    }
    public String delete(Long id) {
        User user = userRepository.findById(id).orElseThrow( () -> new RuntimeException("User not found"));
        userRepository.delete(user);
        return "User deleted";
    }
}
