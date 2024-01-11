package com.example.spring_mysql_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ConflictsController {
    @GetMapping("/conflicts")
    public String getConflicts() {
        return "Getting conflicts";

    }
}
