package com.example.notification.inmemoryinfrastructure.service;

import com.example.notification.infrastructure.service.MailService;

public class NopMailService implements MailService {
    @Override
    public void send(String mailAddress, String title, String content) {
        // nop
    }
}
