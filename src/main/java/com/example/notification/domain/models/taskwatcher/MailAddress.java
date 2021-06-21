package com.example.notification.domain.models.taskwatcher;

public class MailAddress {
    private final String local;
    private final String domain;

    public MailAddress(String local, String domain) {
        this.local = local;
        this.domain = domain;
    }

    @Override
    public String toString() {
        return local + "@" + domain;
    }
}
