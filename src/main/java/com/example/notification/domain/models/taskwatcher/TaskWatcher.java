package com.example.notification.domain.models.taskwatcher;

import com.example.notification.domain.models.task.TaskId;
import lombok.Getter;

@Getter
public class TaskWatcher {
    private final WatcherId id;
    private MailAddress mailAddress;
    private TaskId watching;

    public TaskWatcher(WatcherId id, MailAddress mailAddress, TaskId watching) {
        this.id = id;
        this.mailAddress = mailAddress;
        this.watching = watching;
    }
}
