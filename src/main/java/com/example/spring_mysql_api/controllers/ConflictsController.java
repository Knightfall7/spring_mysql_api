package com.example.spring_mysql_api.controllers;

import org.apache.catalina.users.SparseUserDatabase;
import org.springframework.web.bind.annotation.*;

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
    @PatchMapping("/conflicts")
    public String patchConflicts(){
        return "Patching Conflicts";
}
}
