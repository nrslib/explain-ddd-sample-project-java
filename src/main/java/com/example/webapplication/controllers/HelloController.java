package com.example.webapplication.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Hello")
public class HelloController {
    @GetMapping
    public String get() {
        return "hello";
    }
}
