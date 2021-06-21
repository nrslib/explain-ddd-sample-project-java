package com.example.scrum.application.services.backlog;

import lombok.Getter;

@Getter
public class BacklogUpdateUserStoryCommand {
    private final String id;
    private final String story;

    public BacklogUpdateUserStoryCommand(String id, String story) {
        this.id = id;
        this.story = story;
    }
}
