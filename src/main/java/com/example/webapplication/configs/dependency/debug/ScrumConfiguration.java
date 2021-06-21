package com.example.webapplication.configs.dependency.debug;

import com.example.scrum.application.services.backlog.BacklogApplicationService;
import com.example.scrum.application.services.backlog.query.BacklogQueryService;
import com.example.scrum.application.services.task.TaskApplicationService;
import com.example.scrum.application.services.task.query.TaskQueryService;
import com.example.scrum.domain.models.task.TaskRepository;
import com.example.scrum.domain.models.user.UserContext;
import com.example.scrum.domain.models.userstory.UserStoryRepository;
import com.example.scrum.inmemoryinfrastructure.persistence.task.InMemoryTaskRepository;
import com.example.scrum.inmemoryinfrastructure.persistence.userstory.InMemoryUserStoryRepository;
import com.example.scrum.inmemoryinfrastructure.queryservices.InMemoryBacklogQueryService;
import com.example.scrum.inmemoryinfrastructure.queryservices.InMemoryTaskQueryService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
@Profile("debug")
public class ScrumConfiguration {
    private final ApplicationEventPublisher applicationEventPublisher;
    private final UserContext userContext;

    public ScrumConfiguration(ApplicationEventPublisher applicationEventPublisher, UserContext userContext) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.userContext = userContext;
    }

    @Bean
    public UserStoryRepository userStoryRepository() {
        return new InMemoryUserStoryRepository();
    }

    @Bean
    public TaskRepository scrumTaskRepository() {
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
        return new InMemoryTaskQueryService((InMemoryTaskRepository) scrumTaskRepository());
    }

    @Bean
    @RequestScope
    public TaskApplicationService taskApplicationService() {
        return new TaskApplicationService(applicationEventPublisher, userContext, scrumTaskRepository(), userStoryRepository());
    }
}
