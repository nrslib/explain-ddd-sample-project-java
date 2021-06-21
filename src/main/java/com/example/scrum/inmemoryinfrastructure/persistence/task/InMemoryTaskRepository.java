package com.example.scrum.inmemoryinfrastructure.persistence.task;

import com.example.applicationsupportstack.domainsupport.repository.InMemoryCrudRepository;
import com.example.scrum.domain.models.task.Task;
import com.example.scrum.domain.models.task.TaskId;
import com.example.scrum.domain.models.task.TaskRepository;

import java.util.ArrayList;

public class InMemoryTaskRepository extends InMemoryCrudRepository<TaskId, Task> implements TaskRepository {
    @Override
    protected TaskId getKey(Task value) {
        return value.getId();
    }

    @Override
    protected Task deepClone(Task value) {
        return new Task(
                value.getId(),
                value.getStoryId(),
                value.getDescription(),
                value.getStatus(),
                new ArrayList<>(value.getSignupMembers())
        );
    }
}
