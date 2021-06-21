package com.example.webapplication.configs.startup.debug;

import com.example.notification.domain.models.taskwatcher.MailAddress;
import com.example.notification.domain.models.taskwatcher.TaskWatcher;
import com.example.notification.domain.models.taskwatcher.TaskWatcherRepository;
import com.example.notification.domain.models.taskwatcher.WatcherId;
import com.example.scrum.domain.models.task.*;
import com.example.scrum.domain.models.user.UserId;
import com.example.scrum.domain.models.userstory.UserStory;
import com.example.scrum.domain.models.userstory.UserStoryId;
import com.example.scrum.domain.models.userstory.UserStoryRepository;
import com.example.shared.domain.models.task.ProgressStatus;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Profile("debug")
public class DebugInitialize {
    public DebugInitialize(
            TaskRepository taskRepository,
            UserStoryRepository userStoryRepository,
            com.example.notification.domain.models.task.TaskRepository notificationTaskRepository,
            TaskWatcherRepository taskWatcherRepository
    ) {
        userStoryRepository.save(
                new UserStory(
                        new UserStoryId("test-user-story-id"),
                        "test-story"
                )
        );
        taskRepository.save(
                new Task(
                        new TaskId("test-task-id"),
                        new UserStoryId("test-user-story-id"),
                        new Description("test-description"),
                        ProgressStatus.CREATED,
                        new ArrayList<>(){{add(new UserId("stub-user-id"));}}
                )
        );

        notificationTaskRepository.save(
                new com.example.notification.domain.models.task.Task(
                        new com.example.notification.domain.models.task.TaskId("test-task-id"),
                        "test-task",
                        ProgressStatus.CREATED)
        );

        taskWatcherRepository.save(
                new TaskWatcher(
                        new WatcherId("test-watcher-id"),
                        new MailAddress("test-watcher", "example.com"),
                        new com.example.notification.domain.models.task.TaskId("test-task-id")
                )
        );
    }
}
