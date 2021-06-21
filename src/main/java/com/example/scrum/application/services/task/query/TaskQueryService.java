package com.example.scrum.application.services.task.query;

import com.example.scrum.domain.models.task.Task;

import java.util.List;

public interface TaskQueryService {
    List<Task> getAllTasks();
}
