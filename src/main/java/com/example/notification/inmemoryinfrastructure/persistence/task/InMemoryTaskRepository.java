package com.example.notification.inmemoryinfrastructure.persistence.task;

import com.example.applicationsupportstack.domainsupport.repository.InMemoryCrudRepository;
import com.example.notification.domain.models.task.Task;
import com.example.notification.domain.models.task.TaskId;
import com.example.notification.domain.models.task.TaskRepository;

public class InMemoryTaskRepository extends InMemoryCrudRepository<TaskId, Task> implements TaskRepository {
    @Override
    protected TaskId getKey(Task value) {
        return value.getId();
    }

    @Override
    protected Task deepClone(Task value) {
        return new Task(value.getId(), value.getName(), value.getProgressStatus());
    }
}
