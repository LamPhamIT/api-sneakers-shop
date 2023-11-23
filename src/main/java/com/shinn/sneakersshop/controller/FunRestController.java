package com.shinn.sneakersshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/sayHelloAdmin")
    public String sayHelloAdmin() {
        return "Hello Admin";
    }

    @GetMapping("/sayHelloUser")
    public String sayHelloUser() {
        return "Hello User";
    }

    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello ";
    }
}
