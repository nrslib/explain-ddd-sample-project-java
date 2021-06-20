package com.example.webapplication.controllers;

import com.example.scrum.application.services.backlog.BacklogApplicationService;
import com.example.webapplication.models.backlog.post.BacklogPostRequestModel;
import org.springframework.web.bind.annotation.*;

import java.beans.ConstructorProperties;

@RestController
@RequestMapping("/api/backlog")
public class BacklogController {
    private final BacklogApplicationService backlogApplicationService;

    @ConstructorProperties({"backlogApplicationService"})
    public BacklogController(BacklogApplicationService backlogApplicationService) {
        this.backlogApplicationService = backlogApplicationService;
    }

    @PostMapping
    public void post(@ModelAttribute BacklogPostRequestModel request) {
        backlogApplicationService.addUserStory();
    }
}
