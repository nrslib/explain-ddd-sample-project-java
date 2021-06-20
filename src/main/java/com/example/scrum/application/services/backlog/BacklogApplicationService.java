package com.example.scrum.application.services.backlog;

import com.example.scrum.domain.models.user.UserContext;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

public class BacklogApplicationService {
    private final UserContext userContext;

    public BacklogApplicationService(UserContext userContext) {
        this.userContext = userContext;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void addUserStory() {
        // Write here
    }
}
