package com.shinn.sneakersshop.controller;

import com.shinn.sneakersshop.dto.UsersDto;
import com.shinn.sneakersshop.service.UsersService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(
        name = "User plugins"
)
public class LoginController {

    private final UsersService usersService;


    @Autowired
    public LoginController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UsersDto usersDto) {
        UsersDto savedUser = null;
        savedUser = usersService.save(usersDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Given user details are successfully registered");
    }
}
