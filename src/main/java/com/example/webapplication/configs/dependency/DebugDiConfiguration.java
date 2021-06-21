package com.example.webapplication.configs.dependency;

import com.example.scrum.application.services.backlog.BacklogApplicationService;
import com.example.scrum.domain.models.user.UserContext;
import com.example.scrum.inmemoryinfrastructure.persistence.user.StubUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
@Profile("debug")
public class DebugDiConfiguration {
    @Bean
    public UserContext userContext() {
        return new StubUser();
    }

    @Bean
    @RequestScope
    public BacklogApplicationService backlogApplicationService() {
        return new BacklogApplicationService();
    }
}