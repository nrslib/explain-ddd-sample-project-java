package com.example.webapplication.controllers;

import com.example.scrum.application.services.backlog.BacklogAddUserStoryCommand;
import com.example.scrum.application.services.backlog.BacklogApplicationService;
import com.example.scrum.application.services.backlog.BacklogUpdateUserStoryCommand;
import com.example.scrum.application.services.backlog.query.BacklogQueryService;
import com.example.webapplication.models.backlog.estimate.BacklogEstimateRequestModel;
import com.example.webapplication.models.backlog.get.BacklogGetResponseModel;
import com.example.webapplication.models.backlog.index.BacklogIndexResponseModel;
import com.example.webapplication.models.backlog.get.UserStoryModel;
import com.example.webapplication.models.backlog.index.UserStorySummaryModel;
import com.example.webapplication.models.backlog.post.BacklogPostRequestModel;
import com.example.webapplication.models.backlog.put.BacklogPutRequestModel;
import org.springframework.web.bind.annotation.*;

import java.beans.ConstructorProperties;

@RestController
@RequestMapping("/api/backlog")
public class BacklogController {
    private final BacklogQueryService backlogQueryService;
    private final BacklogApplicationService backlogApplicationService;

    @ConstructorProperties({"queryService", "backlogApplicationService"})
    public BacklogController(BacklogQueryService backlogQueryService, BacklogApplicationService backlogApplicationService) {
        this.backlogQueryService = backlogQueryService;
        this.backlogApplicationService = backlogApplicationService;
    }

    @GetMapping
    public BacklogIndexResponseModel index() {
        var stories = backlogQueryService.getAllUserStories();
        var summaries = stories
                .stream()
                .map(x -> new UserStorySummaryModel(x.getId().getValue()))
                .toList();

        return new BacklogIndexResponseModel(summaries);
    }

    @GetMapping("/{id}")
    public BacklogGetResponseModel get(@PathVariable("id") String id) {
        var optTestUser = backlogApplicationService.getUserStory(id);

        return optTestUser
                .map(x -> new BacklogGetResponseModel(
                        new UserStoryModel(x.getId().getValue(), x.getStory())))
                .orElse(null);
    }

    @PostMapping
    public void post(@ModelAttribute BacklogPostRequestModel request) {
        var command = new BacklogAddUserStoryCommand(request.getStory());
        backlogApplicationService.addUserStory(command);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable("id") String id, @ModelAttribute BacklogPutRequestModel request) {
        backlogApplicationService.updateUserStory(new BacklogUpdateUserStoryCommand(id, request.getStory()));
    }

    @PatchMapping("/{id}/estimate")
    public void estimate(@PathVariable("id") String id, @ModelAttribute BacklogEstimateRequestModel request) {
        backlogApplicationService.estimateUserStory(id, request.getEstimation());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        backlogApplicationService.deleteUserStory(id);
    }
}
