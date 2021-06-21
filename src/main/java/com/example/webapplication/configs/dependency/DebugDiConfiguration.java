package com.example.webapplication.configs.dependency;

import com.example.scrum.application.services.backlog.BacklogApplicationService;
import com.example.scrum.application.services.backlog.query.BacklogQueryService;
import com.example.scrum.application.services.task.TaskApplicationService;
import com.example.scrum.application.services.task.query.TaskQueryService;
import com.example.scrum.domain.models.task.TaskRepository;
import com.example.scrum.domain.models.user.UserContext;
import com.example.scrum.domain.models.userstory.UserStoryRepository;
import com.example.scrum.inmemoryinfrastructure.persistence.task.InMemoryTaskRepository;
import com.example.scrum.inmemoryinfrastructure.persistence.user.StubUser;
import com.example.scrum.inmemoryinfrastructure.persistence.userstory.InMemoryUserStoryRepository;
import com.example.scrum.inmemoryinfrastructure.queryservices.InMemoryBacklogQueryService;
import com.example.scrum.inmemoryinfrastructure.queryservices.InMemoryTaskQueryService;
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
    public UserStoryRepository userStoryRepository() {
        return new InMemoryUserStoryRepository();
    }

    @Bean
    public TaskRepository taskRepository() {
        return new InMemoryTaskRepository();
    }

    @Bean
    @RequestScope
    public BacklogQueryService backlogQueryService() {
        return new InMemoryBacklogQueryService((InMemoryUserStoryRepository) userStoryRepository());
    }

    @Bean
    @RequestScope
    public BacklogApplicationService backlogApplicationService() {
        return new BacklogApplicationService(userStoryRepository());
    }

    @Bean
    @RequestScope
    public TaskQueryService taskQueryService() {
        return new InMemoryTaskQueryService((InMemoryTaskRepository) taskRepository());
    }

    @Bean
    @RequestScope
    public TaskApplicationService taskApplicationService() {
        return new TaskApplicationService(userContext(), taskRepository(), userStoryRepository());
    }
}