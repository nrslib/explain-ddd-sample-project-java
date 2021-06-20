package com.example.scrum.application.services.backlog.query;

import com.example.scrum.domain.models.userstory.UserStory;

import java.util.List;

public interface BacklogQueryService {
    List<UserStory> getAllUserStories();
}
