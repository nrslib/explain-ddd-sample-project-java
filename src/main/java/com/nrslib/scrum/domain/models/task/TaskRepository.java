package com.nrslib.scrum.domain.models.task;

import java.util.Optional;

public interface TaskRepository {
    Optional<Task> find(TaskId id);
    void save(Task story);
    void delete(Task story);
}
