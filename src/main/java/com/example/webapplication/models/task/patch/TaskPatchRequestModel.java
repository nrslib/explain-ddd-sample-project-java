package com.example.webapplication.models.task.patch;

import com.example.shared.domain.models.task.ProgressStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskPatchRequestModel {
    private ProgressStatus changeStatus;
}
