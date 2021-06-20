package com.nrslib.scrum.application.services.task;

import com.nrslib.applicationsupportstack.applicationsupport.exceptions.NotFoundException;
import com.nrslib.scrum.domain.models.task.*;
import com.nrslib.scrum.domain.models.user.UserContext;
import com.nrslib.scrum.domain.models.userstory.UserStoryId;
import com.nrslib.scrum.domain.models.userstory.UserStoryRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

public class TaskApplicationService {
    private final UserContext userContext;
    private final TaskRepository taskRepository;
    private final UserStoryRepository userStoryRepository;

    public TaskApplicationService(UserContext userContext, TaskRepository taskRepository, UserStoryRepository userStoryRepository) {
        this.userContext = userContext;
        this.taskRepository = taskRepository;
        this.userStoryRepository = userStoryRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void create(TaskAddCommand command) {
        Objects.requireNonNull(command);

        var storyId = new UserStoryId(command.getStoryId());
        var optStory = userStoryRepository.find(storyId);
        if (optStory.isEmpty()) {
            throw new NotFoundException("Story not found. id:" + storyId);
        }

        var story = optStory.get();
        var task = story.createTask(new Description(command.getDescription()));

        taskRepository.save(task);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void signup(String id) {
        Objects.requireNonNull(id);

        var task = getTaskOrThrowNotFound(id);
        task.signup(userContext.getId());

        taskRepository.save(task);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void changeStatus(String id, ProgressStatus status) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(status);

        var task = getTaskOrThrowNotFound(id);
        task.changeStatus(status);

        taskRepository.save(task);
    }

    private Task getTaskOrThrowNotFound(String id) {
        var taskId = new TaskId(id);
        var optTask = taskRepository.find(taskId);
        if (optTask.isEmpty()) {
            throw new NotFoundException("Task not found. id:" + taskId);
        }

        return optTask.get();
    }
}