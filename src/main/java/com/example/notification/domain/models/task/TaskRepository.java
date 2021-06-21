package com.example.notification.domain.models.task;

import java.util.Optional;

public interface TaskRepository {
    Optional<Task> find(TaskId id);
    void save(Task task);
}
