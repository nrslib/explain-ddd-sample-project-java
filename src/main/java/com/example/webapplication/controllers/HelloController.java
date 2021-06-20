package com.example.webapplication.controllers;

import com.example.scrum.domain.models.userstory.UserStoryId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Hello")
public class HelloController {
    @GetMapping
    public String get() {
        var story = new UserStoryId("test");
        var test =story.getValue();
        return "hello";
    }
}
