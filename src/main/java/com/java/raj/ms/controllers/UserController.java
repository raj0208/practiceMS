package com.java.raj.ms.controllers;

import com.java.raj.ms.exceptions.UserNotFoundException;
import com.java.raj.ms.model.User;

import com.java.raj.ms.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository repository) {
        this.userRepository = repository;
    }

    @GetMapping("/users")
    public List<User>  retrieveAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveAllUsers(@PathVariable int id) {
        Optional<User> user = this.userRepository.findById(id);

        if (!user.isPresent()) {
            throw new UserNotFoundException("User with Id " + id + " not found");
        }

        return user.get();
    }
}
