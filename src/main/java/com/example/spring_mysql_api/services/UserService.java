package com.example.spring_mysql_api.services;

import com.example.spring_mysql_api.models.User;
import com.example.spring_mysql_api.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserService {

    @Autowired
   private UsersRepository repository;

    //Get All users
    public Iterable<User> getAllUsers(){
        return repository.findAll();
    }

    //Get one user
    public Optional<User> getUserById(Long id){
        return repository.findById(id);
    }

    //Create a user
    public User createUser(User user){
        return repository.save(user);
    }
    // Delete user
    public boolean deleteUserById(Long id) {
        //Check if user already exists
        if (repository.existsById(id)){

            //Remove and return true if it exists.
            return true;
        }

        //Otherwise return false.
        return false;
    }
    //Update user
    public boolean updateUserById(Long id, User user){
        if (repository.existsById(id)){
            user.setId(id);
            repository.save(user);

            //Remove and return true if it exists.
            return true;
        }

        //Otherwise return false.
        return false;
    }

    public boolean seed() {
            try {
                User[] users = {

                        new User("Christian", "christtt@gmail.com"),
                        new User("Mark", "mark@gmail.com"),
                        new User("Maxx", "Baxxx@gmail.com"),
                        new User("Mayo", "mayoB@gmail.com"),
                        new User("Bob", "bobb@gmail.com")
                };

                var userList = Arrays.stream((users)).toList();

                repository.saveAll(userList);

                return true;

            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
    }


}

