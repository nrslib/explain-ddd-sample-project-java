package com.example.notification.handler;

import com.example.notification.application.NotificationApplicationService;
import com.example.scrum.domain.models.task.events.TaskCreatedEvent;
import com.example.scrum.domain.models.task.events.TaskStatusChangedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
public class NotificationEventHandler {
    private final NotificationApplicationService notificationApplicationService;

    public NotificationEventHandler(NotificationApplicationService notificationApplicationService) {
        this.notificationApplicationService = notificationApplicationService;
    }

    @TransactionalEventListener
    public void onTaskCreated(TaskCreatedEvent event) {
        log.info("task created");
    }

    @TransactionalEventListener
    public void onTaskStatusChanged(TaskStatusChangedEvent event) {
        notificationApplicationService.notifyChangeStatus(event.getTaskId());
    }
}
