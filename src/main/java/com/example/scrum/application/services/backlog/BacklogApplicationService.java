package com.example.scrum.application.services.backlog;

import com.example.scrum.domain.models.userstory.UserStory;
import com.example.scrum.domain.models.userstory.UserStoryId;
import com.example.scrum.domain.models.userstory.UserStoryRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

public class BacklogApplicationService {
    private final UserStoryRepository userStoryRepository;

    public BacklogApplicationService(UserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void addUserStory(BacklogAddUserStoryCommand command) {
        Objects.requireNonNull(command.getStory());

        var id = new UserStoryId(UUID.randomUUID().toString());
        var story = new UserStory(id, command.getStory());

        userStoryRepository.save(story);
    }
}
