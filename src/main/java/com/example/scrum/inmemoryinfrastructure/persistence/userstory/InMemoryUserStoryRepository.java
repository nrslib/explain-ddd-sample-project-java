package com.example.scrum.inmemoryinfrastructure.persistence.userstory;

import com.example.applicationsupportstack.domainsupport.repository.InMemoryCrudRepository;
import com.example.scrum.domain.models.userstory.UserStory;
import com.example.scrum.domain.models.userstory.UserStoryId;
import com.example.scrum.domain.models.userstory.UserStoryRepository;

public class InMemoryUserStoryRepository extends InMemoryCrudRepository<UserStoryId, UserStory> implements UserStoryRepository {
    @Override
    protected UserStoryId getKey(UserStory value) {
        return value.getId();
    }

    @Override
    protected UserStory deepClone(UserStory value) {
        return new UserStory(
                value.getId(),
                value.getStory()
        );
    }
}
