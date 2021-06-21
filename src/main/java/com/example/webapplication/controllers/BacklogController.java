package com.example.webapplication.controllers;

import com.example.scrum.application.services.backlog.BacklogAddUserStoryCommand;
import com.example.scrum.application.services.backlog.BacklogApplicationService;
import com.example.webapplication.models.backlog.estimate.BacklogEstimateRequestModel;
import com.example.webapplication.models.backlog.get.BacklogGetResponseModel;
import com.example.webapplication.models.backlog.index.BacklogIndexResponseModel;
import com.example.webapplication.models.backlog.post.BacklogPostRequestModel;
import com.example.webapplication.models.backlog.put.BacklogPutRequestModel;
import org.springframework.web.bind.annotation.*;

import javax.management.ConstructorParameters;
import java.beans.ConstructorProperties;

@RestController
@RequestMapping("/api/backlog")
public class BacklogController {
    private final BacklogApplicationService backlogApplicationService;

    @ConstructorProperties({"backlogApplicationService"})
    public BacklogController(BacklogApplicationService backlogApplicationService) {
        this.backlogApplicationService = backlogApplicationService;
    }

    @GetMapping
    public BacklogIndexResponseModel index() {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/{id}")
    public BacklogGetResponseModel get(@PathVariable("id") String id) {
        throw new UnsupportedOperationException();
    }

    @PostMapping
    public void post(@ModelAttribute BacklogPostRequestModel request) {
        var command = new BacklogAddUserStoryCommand(request.getStory());
        backlogApplicationService.addUserStory(command);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable("id") String id, @ModelAttribute BacklogPutRequestModel request) {
        throw new UnsupportedOperationException();
    }

    @PatchMapping("/{id}/estimate")
    public void estimate(@PathVariable("id") String id, @ModelAttribute BacklogEstimateRequestModel request) {
        throw new UnsupportedOperationException();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        throw new UnsupportedOperationException();
    }
}
