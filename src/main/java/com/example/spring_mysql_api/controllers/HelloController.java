package com.example.spring_mysql_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
        public String getHello(){
         return "Hello Chris Nkuutu" +
                 "" +
                 " Welcome to your first first working API" +
                 " it feels good doesn't it " + "Just trying to play around " +
                 " with this new API";
        }

}
