package com.nrslib.scrum.domain.models.task;

public class IllegalChangeStatusException extends RuntimeException {
    public IllegalChangeStatusException(String message) {
        super(message);
    }
}
