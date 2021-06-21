package com.example.scrum.inmemoryinfrastructure.queryservices;

import com.example.scrum.application.services.task.query.TaskQueryService;
import com.example.scrum.domain.models.task.Task;
import com.example.scrum.inmemoryinfrastructure.persistence.task.InMemoryTaskRepository;

import java.util.List;

public class InMemoryTaskQueryService implements TaskQueryService {
    private final InMemoryTaskRepository taskRepository;

    public InMemoryTaskQueryService(InMemoryTaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.keyToValue.values().stream().toList();
    }
}
