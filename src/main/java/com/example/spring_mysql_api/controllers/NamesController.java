package com.example.spring_mysql_api.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class NamesController {
    @GetMapping("/names")
    public String getName() {
        return "Your name is Chris Nkuutu.....";
    }

    @PostMapping("/names") // Create a name
    public String postName(@RequestBody String name) {
        return "Posting your name: " + name;
    }

    @PutMapping("/names") //Update a name
    public String putName() {
        return "Updating your name!";
    }

    @DeleteMapping("/names") //Delete a name
    public String deleteName() {
        return "Deleting your name!";
    }
}
