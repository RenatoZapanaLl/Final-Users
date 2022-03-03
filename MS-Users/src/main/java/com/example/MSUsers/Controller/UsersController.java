package com.example.MSUsers.Controller;


import com.example.MSUsers.Domain.Users;
import com.example.MSUsers.Repository.UsersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UsersController {
    private UsersRepository usersRepository;

    public UsersController(UsersRepository studentRepository) {
        this.usersRepository = studentRepository;
    }

    @GetMapping("/Users")
    public Map<String, Users> findAll() {
        return usersRepository.findAll();
    }

    @GetMapping("/Users/{id}")
    public Users findById(@PathVariable String id) {
        return usersRepository.findById(id);
    }

    @PostMapping("/Users")
    public void createClients(@RequestBody Users users) {
        usersRepository.save(users);
    }
    @DeleteMapping("/Users/{id}")
    public void deleteClients(@PathVariable String id) {
        usersRepository.delete(id);
    }
}
