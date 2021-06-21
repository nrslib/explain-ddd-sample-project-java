package com.example.notification.inmemoryinfrastructure.persistence.taskwatcher;

import com.example.applicationsupportstack.domainsupport.repository.InMemoryCrudRepository;
import com.example.notification.domain.models.task.TaskId;
import com.example.notification.domain.models.taskwatcher.TaskWatcher;
import com.example.notification.domain.models.taskwatcher.TaskWatcherRepository;
import com.example.notification.domain.models.taskwatcher.WatcherId;

import java.util.List;

public class InMemoryTaskWatcherRepository extends InMemoryCrudRepository<WatcherId, TaskWatcher> implements TaskWatcherRepository {
    @Override
    protected WatcherId getKey(TaskWatcher value) {
        return value.getId();
    }

    @Override
    protected TaskWatcher deepClone(TaskWatcher value) {
        return new TaskWatcher(value.getId(), value.getMailAddress(), value.getWatching());
    }

    @Override
    public List<TaskWatcher> find(TaskId taskId) {
        return keyToValue.values().stream().filter(x -> x.getWatching().equals(taskId)).toList();
    }
}
