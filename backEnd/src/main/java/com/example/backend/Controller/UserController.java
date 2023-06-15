package com.example.backend.Controller;

import com.example.backend.DTO.UserRequestDTO;
import com.example.backend.DTO.UserResponseDTO;
import com.example.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v2/user")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @GetMapping(value = "/list",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponseDTO> list() {
        return userService.findAll();
    }

    @CrossOrigin
    @GetMapping(value = "/find/{id}",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @CrossOrigin
    @PostMapping(value = "/save",consumes = "application/json",produces = "application/json")
    public ResponseEntity<UserRequestDTO> save(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.created(null).body(userService.save(userRequestDTO));
    }

    @CrossOrigin
    @PutMapping(value = "/update/{id}",consumes = "application/json",produces = "application/json")
    public ResponseEntity<UserRequestDTO> update(@PathVariable Long id,@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userService.update(id,userRequestDTO));
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/{id}",produces = "application/json")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
