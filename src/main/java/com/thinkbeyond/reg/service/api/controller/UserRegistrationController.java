package com.thinkbeyond.reg.service.api.controller;

import com.thinkbeyond.reg.service.api.entity.UserRegDetails;
import com.thinkbeyond.reg.service.api.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping("/register")
    public String register(@RequestBody UserRegDetails user) {
        userRegistrationService.register(user);
        return "Hi " + user.getName() + " your Registration process successfully completed";
    }

    @GetMapping("/getAllUsers")
    public List<UserRegDetails> findAllUsers() {
        return userRegistrationService.findAllUsers();
    }

    @GetMapping("/findUser/{email}")
    public List<UserRegDetails> findUser(@PathVariable String email) {
        return userRegistrationService.findByEmail(email);
    }

    @DeleteMapping("/cancel/{id}")
    public List<UserRegDetails> cancelRegistration(@PathVariable int id) {
        userRegistrationService.cancelRegistration(id);
        return userRegistrationService.findAllUsers();
    }

}
