package com.example.notification.application;

import com.example.applicationsupportstack.applicationsupport.exceptions.NotFoundException;
import com.example.notification.domain.models.task.TaskId;
import com.example.notification.domain.models.task.TaskRepository;
import com.example.notification.domain.models.taskwatcher.TaskWatcherRepository;
import com.example.notification.infrastructure.service.MailService;

public class NotificationApplicationService {
    private final TaskWatcherRepository watcherRepository;
    private final TaskRepository taskRepository;
    private final MailService mailService;

    public NotificationApplicationService(TaskWatcherRepository watcherRepository, TaskRepository taskRepository, MailService mailService) {
        this.watcherRepository = watcherRepository;
        this.taskRepository = taskRepository;
        this.mailService = mailService;
    }

    public void notifyChangeStatus(String taskId) {
        var id = new TaskId(taskId);
        var optTask = taskRepository.find(id);

        if (optTask.isEmpty()) {
            throw new NotFoundException("task not found. id:" + id);
        }
        var task = optTask.get();

        var watchers = watcherRepository.find(id);
        watchers.forEach(x -> {
            var title = "Task " + task.getName() + " status changed.";
            var content = "Task status change to " + task.getProgressStatus().toString();
            mailService.send(x.getMailAddress().toString(), title, content);
        });
    }
}
