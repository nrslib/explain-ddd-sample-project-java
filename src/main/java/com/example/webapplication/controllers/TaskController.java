package com.example.webapplication.controllers;

import com.example.webapplication.models.task.get.TaskGetResponseModel;
import com.example.webapplication.models.task.index.TaskIndexResponseModel;
import com.example.webapplication.models.task.patch.TaskPatchRequestModel;
import com.example.webapplication.models.task.post.TaskPostRequestModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @GetMapping
    public TaskIndexResponseModel index() {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/{id}")
    public TaskGetResponseModel get(@PathVariable("id") String id) {
        throw new UnsupportedOperationException();
    }

    @PostMapping
    public void post(TaskPostRequestModel request) {
        throw new UnsupportedOperationException();
    }

    @PatchMapping("/{id}/signup")
    public void signup(@PathVariable("id") String id) {
        throw new UnsupportedOperationException();
    }

    @PatchMapping("/{id}")
    public void patch(@PathVariable("id") String id, TaskPatchRequestModel request) {
        throw new UnsupportedOperationException();
    }
}
