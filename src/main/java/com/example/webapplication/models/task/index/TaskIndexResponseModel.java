package com.example.webapplication.models.task.index;

import lombok.Getter;

import java.util.List;

@Getter
public class TaskIndexResponseModel {
    private final List<TaskSummaryModel> summaries;

    public TaskIndexResponseModel(List<TaskSummaryModel> summaries) {
        this.summaries = summaries;
    }
}
