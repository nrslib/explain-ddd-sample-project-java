package com.example.scrum.domain.models.task;

import com.example.applicationsupportstack.domainsupport.aggregate.AggregateRoot;
import com.example.scrum.domain.models.task.events.TaskStatusChangedEvent;
import com.example.scrum.domain.models.user.UserContext;
import com.example.scrum.domain.models.user.UserId;
import com.example.scrum.domain.models.userstory.UserStoryId;
import com.example.shared.domain.models.task.ProgressStatus;
import lombok.Getter;

import java.util.List;

@Getter
public class Task extends AggregateRoot {
    private final TaskId id;
    private final UserStoryId storyId;
    private Description description;
    private ProgressStatus status;
    private List<UserId> signupMembers;

    public Task(TaskId id, UserStoryId storyId, Description description, ProgressStatus status, List<UserId> signupMembers) {
        this.id = id;
        this.storyId = storyId;
        this.description = description;
        this.status = status;
        this.signupMembers = signupMembers;
    }

    public boolean isReady() {
        return signupMembers.size() > 0;
    }

    public void changeDescription(Description description) {
        this.description = description;
    }

    public void changeStatus(ProgressStatus status) {
        if (!isReady()) {
            throw new IllegalChangeStatusException("ステータス変更の準備が整っていません");
        }

        registerEvent(new TaskStatusChangedEvent(this.id));
        this.status = status;
    }

    public void signup(UserContext user) {
        var userId = user.getId();
        if (signupMembers.stream().anyMatch(x -> x.equals(userId))){
            return;
        }

        signupMembers.add(userId);
    }
}
