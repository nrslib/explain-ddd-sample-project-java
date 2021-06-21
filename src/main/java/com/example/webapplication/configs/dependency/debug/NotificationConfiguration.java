package com.example.webapplication.configs.dependency.debug;

import com.example.notification.application.NotificationApplicationService;
import com.example.notification.domain.models.task.TaskRepository;
import com.example.notification.domain.models.taskwatcher.TaskWatcherRepository;
import com.example.notification.handler.NotificationEventHandler;
import com.example.notification.infrastructure.service.MailService;
import com.example.notification.inmemoryinfrastructure.persistence.task.InMemoryTaskRepository;
import com.example.notification.inmemoryinfrastructure.persistence.taskwatcher.InMemoryTaskWatcherRepository;
import com.example.notification.inmemoryinfrastructure.service.NopMailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
@Profile("debug")
public class NotificationConfiguration {
    @Bean
    public TaskWatcherRepository taskWatcherRepository() {
        return new InMemoryTaskWatcherRepository();
    }

    @Bean
    public TaskRepository notificationTaskRepository() {
        return new InMemoryTaskRepository();
    }

    @Bean
    public NotificationEventHandler notificationEventHandler() {
        return new NotificationEventHandler(notificationApplicationService());
    }

    @Bean
    @RequestScope
    public NotificationApplicationService notificationApplicationService() {
        return new NotificationApplicationService(taskWatcherRepository(), notificationTaskRepository(), mailService());
    }

    @Bean
    public MailService mailService() {
        return new NopMailService();
    }
}
