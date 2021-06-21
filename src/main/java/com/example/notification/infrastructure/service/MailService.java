package com.example.notification.infrastructure.service;

public interface MailService {
    void send(String mailAddress, String title, String content);
}
