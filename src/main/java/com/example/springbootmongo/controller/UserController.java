package com.example.springbootmongo.controller;


import com.example.springbootmongo.model.User;
import com.example.springbootmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/hello") //endpoint is a string so needs to be in double quotes
    public String helloWorld(){
        return "Hello World";
    }

    //methods from within userServiceImpl implemented within userService
    @GetMapping("/listUsers")
    public List<User> listUsers(){
        //go into userService which has listUsers method in implementation which is implemented in userService
        return userService.listUsers();
    }

    @PostMapping("/signup")
    //sending out body content
    public User createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }

    //returns user stored email
    @GetMapping("/user/{email}")
    //@PathVariable = {variableName} in url/endpoint path
    public User getUserByEmail(@PathVariable String email){
        return userService.findUserByEmail(email);
    }
}
