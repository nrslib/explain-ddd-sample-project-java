package com.example.webapplication.models.task.get;

import lombok.Getter;

import java.util.List;

@Getter
public class TaskModel {
    private final String id;
    private final String userStoryId;
    private final String description;
    private final String status;
    private final List<String> signupMembers;

    public TaskModel(String id, String userStoryId, String description, String status, List<String> signupMembers) {
        this.id = id;
        this.userStoryId = userStoryId;
        this.description = description;
        this.status = status;
        this.signupMembers = signupMembers;
    }
}
