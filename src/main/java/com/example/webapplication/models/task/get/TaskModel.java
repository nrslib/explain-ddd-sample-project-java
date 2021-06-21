package com.example.webapplication.models.task.get;

import com.example.shared.domain.models.task.ProgressStatus;
import lombok.Getter;

import java.util.List;

@Getter
public class TaskModel {
    private final String id;
    private final String userStoryId;
    private final String description;
    private final ProgressStatus status;
    private final List<String> signupMembers;

    public TaskModel(String id, String userStoryId, String description, ProgressStatus status, List<String> signupMembers) {
        this.id = id;
        this.userStoryId = userStoryId;
        this.description = description;
        this.status = status;
        this.signupMembers = signupMembers;
    }
}
