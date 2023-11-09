package com.shinn.sneakersshop.controller;

import com.shinn.sneakersshop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final UsersService usersService;

    @Autowired
    public LoginController(UsersService usersService) {
        this.usersService = usersService;
    }

//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser() {
//        return
//    }
}
