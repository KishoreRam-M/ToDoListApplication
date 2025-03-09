package com.Project.ToDoApplication.Security.controller;

import com.Project.ToDoApplication.Security.MyUserDetailsService;
import com.Project.ToDoApplication.Security.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SecurityController {
    @Autowired
    MyUserDetailsService service;
    @PostMapping("/register")
    public Users register(@RequestBody Users user)
    {
       return   service.toRegister(user);
    }
}
