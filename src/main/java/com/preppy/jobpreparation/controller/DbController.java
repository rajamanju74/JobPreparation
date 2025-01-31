package com.preppy.jobpreparation.controller;

import com.preppy.jobpreparation.db.User;
import com.preppy.jobpreparation.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/db")
public class DbController {
    @Autowired
    DbService dbService;

    @GetMapping
    public List<User> getUser(){
        return dbService.getAllUsers();
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return dbService.saveUser(user);
    }
}
