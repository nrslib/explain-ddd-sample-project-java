package com.example.webapplication.controllers;

import com.example.applicationsupportstack.domainsupport.valueobjects.ValueObject;
import com.example.scrum.application.services.task.TaskAddCommand;
import com.example.scrum.application.services.task.TaskApplicationService;
import com.example.scrum.application.services.task.query.TaskQueryService;
import com.example.webapplication.models.task.get.TaskGetResponseModel;
import com.example.webapplication.models.task.get.TaskModel;
import com.example.webapplication.models.task.index.TaskIndexResponseModel;
import com.example.webapplication.models.task.index.TaskSummaryModel;
import com.example.webapplication.models.task.post.TaskPostRequestModel;
import com.example.webapplication.models.task.patch.TaskPatchRequestModel;
import org.springframework.web.bind.annotation.*;

import java.beans.ConstructorProperties;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    private final TaskQueryService taskQueryService;
    private final TaskApplicationService taskApplicationService;

    @ConstructorProperties({"taskQueryService", "taskApplicationService"})
    public TaskController(TaskQueryService taskQueryService, TaskApplicationService taskApplicationService) {
        this.taskQueryService = taskQueryService;
        this.taskApplicationService = taskApplicationService;
    }

    @GetMapping
    public TaskIndexResponseModel index() {
        var tasks = taskQueryService.getAllTasks();
        var summaries = tasks
                .stream()
                .map(x -> new TaskSummaryModel(x.getId().getValue()))
                .toList();

        return new TaskIndexResponseModel(summaries);
    }

    @GetMapping("/{id}")
    public TaskGetResponseModel get(@PathVariable("id") String id) {
        var optTask = taskApplicationService.getTask(id);

        return optTask
                .map(task -> new TaskModel(
                        task.getId().getValue(),
                        task.getStoryId().getValue(),
                        task.getDescription().getValue(),
                        task.getStatus(),
                        task.getSignupMembers().stream().map(ValueObject::getValue).toList()
                ))
                .map(TaskGetResponseModel::new)
                .orElse(null);
    }

    @PostMapping
    public void post(TaskPostRequestModel request) {
        var command = new TaskAddCommand(request.getStoryId(), request.getDescription());
        taskApplicationService.create(command);
    }

    @PatchMapping("/{id}/signup")
    public void signup(@PathVariable("id") String id) {
        taskApplicationService.signup(id);
    }

    @PatchMapping("/{id}")
    public void patch(@PathVariable("id") String id, TaskPatchRequestModel request) {
        var changeStatus = request.getChangeStatus();
        if (changeStatus != null) {
            taskApplicationService.changeStatus(id, changeStatus);
        }
    }
}
