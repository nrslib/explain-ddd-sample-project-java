package com.example.scrum.domain.models.task;

import com.example.scrum.domain.models.user.UserId;
import com.example.scrum.domain.models.userstory.UserStoryId;

import java.util.ArrayList;

public class Task {
    private final TaskId id;
    private final UserStoryId storyId;
    private Description description;
    private ProgressStatus status;
    private ArrayList<UserId> signupMembers;

    public Task(TaskId id, UserStoryId storyId, Description description, ProgressStatus status, ArrayList<UserId> signupMembers) {
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

        this.status = status;
    }

    public void signup(UserId userId) {
        if (signupMembers.stream().anyMatch(x -> x.equals(userId))){
            return;
        }

        signupMembers.add(userId);
    }
}
