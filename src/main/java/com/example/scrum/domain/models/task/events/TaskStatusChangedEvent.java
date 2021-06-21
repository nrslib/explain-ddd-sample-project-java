package com.example.scrum.domain.models.task.events;

import com.example.scrum.domain.models.task.TaskId;
import lombok.Getter;

@Getter
public class TaskStatusChangedEvent {
    private final String taskId;

    public TaskStatusChangedEvent(TaskId taskId) {
        this.taskId = taskId.getValue();
    }
}
