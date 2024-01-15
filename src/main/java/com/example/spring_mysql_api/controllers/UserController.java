package com.example.spring_mysql_api.controllers;

import com.example.spring_mysql_api.models.User;
import com.example.spring_mysql_api.repositories.UsersRepository;
import com.example.spring_mysql_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@RequestMapping(path="/users")
public class UserController {

    @Autowired
    private UserService service;

//    Get All the Users

//    GET:  localhost:8080/users
    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
       return service.getAllUsers();
    }


//    GET:  localhost:8080/users/5
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return service.getUserById(id);
    }

    //POST: localhost:8080/users
    @PostMapping()
    public User postUser(@RequestBody User user) {
       return service.createUser(user);
    }

//    DELETE: localhost:8080/users/5
    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id) {
      return service.deleteUserById(id);
    }
//    PUT: localhost:8080/users/5
    @PutMapping("/{id}")
    public boolean putUser(@PathVariable long id,@RequestBody User user){
        return service.updateUserById(id,user);
    }

//    POST: localhost:8080/users/seed
    @PostMapping("/seed")
    public boolean postSeedUsers(){
        return service.seed();
    }

    }



