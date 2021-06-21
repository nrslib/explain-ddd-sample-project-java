package com.example.scrum.application.services.backlog;

import com.example.applicationsupportstack.applicationsupport.exceptions.NotFoundException;
import com.example.scrum.domain.models.userstory.*;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class BacklogApplicationService {
    private final UserStoryRepository userStoryRepository;

    public BacklogApplicationService(UserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }

    public Optional<UserStory> getUserStory(String aId) {
        Objects.requireNonNull(aId);

        var id = new UserStoryId(aId);

        return userStoryRepository.find(id);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void addUserStory(BacklogAddUserStoryCommand command) {
        Objects.requireNonNull(command.getStory());

        var id = new UserStoryId(UUID.randomUUID().toString());
        var story = new UserStory(id, command.getStory());

        userStoryRepository.save(story);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void updateUserStory(BacklogUpdateUserStoryCommand command) {
        Objects.requireNonNull(command);

        var id = new UserStoryId(command.getId());
        var optStory = userStoryRepository.find(id);

        optStory.ifPresentOrElse(
                userStory -> {
                    var story = command.getStory();
                    if (story != null) {
                        userStory.modifyStory(story);
                    }

                    userStoryRepository.save(userStory);
                },
                () -> {
                    throw new NotFoundException("Unknown story of id: " + id);
                }
        );
    }

    @Transactional
    public void estimateUserStory(String aId, int estimation) {
        Objects.requireNonNull(aId);

        var id = new UserStoryId(aId);
        var optStory = userStoryRepository.find(id);

        optStory.ifPresentOrElse(
                x -> {
                    x.estimate(estimation);
                    userStoryRepository.save(x);
                },
                () -> {
                    throw new NotFoundException("Unknown story of id: " + aId);
                }
        );
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void deleteUserStory(String aId) {
        Objects.requireNonNull(aId);

        var id = new UserStoryId(aId);
        var optStory = userStoryRepository.find(id);

        optStory.ifPresent(userStoryRepository::delete);
    }
}
