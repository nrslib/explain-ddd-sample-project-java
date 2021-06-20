package com.nrslib.scrum.application.services.task;

import lombok.Getter;

@Getter
public class TaskAddCommand {
    private String storyId;
    private String description;

    public TaskAddCommand(String storyId, String description) {
        this.storyId = storyId;
        this.description = description;
    }
}
