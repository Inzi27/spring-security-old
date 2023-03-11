package io.inzi.springsecurityold.controller;

import io.inzi.springsecurityold.model.UserEntity;
import io.inzi.springsecurityold.reository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("hello")
    public String hello(){
        return "Hello!";
    }

    @GetMapping("user")
    public String user(){
        return "Hi User/Admin!";
    }

    @GetMapping("admin")
    public String admin(){
        return "Hi Admin!";
    }

    @PostMapping("save")
    public String addUser(@RequestBody UserEntity user){
        userRepository.save(user);
        return "User added";
    }
}
