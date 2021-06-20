package com.example.scrum.inmemoryinfrastructure.queryservices;

import com.example.scrum.application.services.backlog.query.BacklogQueryService;
import com.example.scrum.domain.models.userstory.UserStory;
import com.example.scrum.inmemoryinfrastructure.persistence.userstory.InMemoryUserStoryRepository;

import java.util.List;

public class InMemoryBacklogQueryService implements BacklogQueryService {
    private final InMemoryUserStoryRepository userStoryRepository;

    public InMemoryBacklogQueryService(InMemoryUserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }

    @Override
    public List<UserStory> getAllUserStories() {
        return userStoryRepository.keyToValue.values().stream().toList();
    }
}
