package com.example.spring_mysql_api.controllers;

import com.example.spring_mysql_api.models.User;
import com.example.spring_mysql_api.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@RequestMapping(path="/users")
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    //Get All the Users
    //localhost:8080/users
    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @PostMapping()
    public Long postUser(@RequestBody User user) {
        usersRepository.save(user);
        return user.getId();
    }

    @PostMapping("/seed")
    public boolean postSeedUsers() {
        try {
            User[] users = {new User("Christian", "christtt@gmail.com"),
                    new User("Mark", "mark@gmail.com"),
                    new User("Maxx", "Baxxx@gmail.com"),
                    new User("Mayo", "mayoB@gmail.com"),
                    new User("Bob", "bobb@gmail.com")
            };

            var userList = Arrays.stream((users)).toList();
            usersRepository.saveAll(userList);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
        @DeleteMapping("/users/delete/{id}")
        @ResponseStatus(code = HttpStatus.NO_CONTENT)
        public void removeUser ( @PathVariable int id){
            User user = usersRepository.findById(Long.valueOf(id)).get();
            usersRepository.delete(user);
        }
    }


    /**
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = usersRepository.findById(Long.valueOf(id)).get();

        return user;
    }
    **/

    /**@PostMapping("/user/add")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = usersRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);

    } **/
    /**
    @PutMapping("/user/update/{id}")
    public User updateUsers(@PathVariable int id) {
        User user = usersRepository.findById(Long.valueOf(id)).get();
        user.setName("poonam");
        usersRepository.save(user);
        return user;

    }
    **/



