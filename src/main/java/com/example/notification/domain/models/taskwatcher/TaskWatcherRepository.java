package com.example.notification.domain.models.taskwatcher;

import com.example.notification.domain.models.task.TaskId;

import java.util.List;

public interface TaskWatcherRepository {
    List<TaskWatcher> find(TaskId taskId);
    void save(TaskWatcher watcher);
}
