package com.shinn.sneakersshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world";
    }

}
