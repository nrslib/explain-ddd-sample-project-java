package com.example.scrum.domain.models.userstory;

import com.example.scrum.domain.models.task.Description;
import com.example.scrum.domain.models.task.ProgressStatus;
import com.example.scrum.domain.models.task.Task;
import com.example.scrum.domain.models.task.TaskId;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class UserStory {
    @Getter
    private final UserStoryId id;
    @Getter
    private String story;
    @Getter
    private int estimation;

    public UserStory(UserStoryId id, String story) {
        this.id = id;
        this.story = story;
    }

    public UserStory(UserStoryId id, String story, int estimation) {
        this(id, story);

        this.estimation = estimation;
    }

    public void estimate(int estimation) {
        if (estimation < 0) {
            throw new IllegalArgumentException("estimation must be positive numbers.");
        }

        this.estimation = estimation;
    }

    public void modifyStory(String story) {
        Objects.requireNonNull(story);

        this.story = story;
    }

    public Task createTask(Description description) {
        return new Task(
                new TaskId(UUID.randomUUID().toString()),
                id,
                description,
                ProgressStatus.CREATED,
                new ArrayList<>()
        );
    }
}
