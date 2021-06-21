package com.example.notification.domain.models.task;

import com.example.shared.domain.models.task.ProgressStatus;
import lombok.Getter;

@Getter
public class Task {
    private final TaskId id;
    private final String name;
    private final ProgressStatus progressStatus;

    public Task(TaskId id, String name, ProgressStatus progressStatus) {
        this.id = id;
        this.name = name;
        this.progressStatus = progressStatus;
    }
}
