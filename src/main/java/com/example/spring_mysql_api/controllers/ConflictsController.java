package com.example.spring_mysql_api.controllers;

import org.apache.catalina.users.SparseUserDatabase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ConflictsController {
    @GetMapping("/conflicts")
    public String getConflicts() {
        return "Getting conflicts";

    }
    @DeleteMapping("/conflicts")
    public String deleteConflicts(){
        return "Deleting Conflicts";
    }
    @PostMapping("/conflicts")
    public String postConflicts(){
        return "Posting Conflicts";
    }

}
