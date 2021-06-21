package com.example.scrum.domain.models.userstory;

import lombok.Getter;

@Getter
public class UserStory {
    private final UserStoryId id;
    private String story;

    public UserStory(UserStoryId id, String story) {
        this.id = id;
        this.story = story;
    }
}
