package com.example.scrum.domain.models.task.events;

import org.springframework.context.ApplicationEvent;

public class TaskCreatedEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public TaskCreatedEvent(Object source) {
        super(source);
    }
}
