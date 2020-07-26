package com.vitaliyyats.sprint13.service;

import com.vitaliyyats.sprint13.entity.Sprint;
import com.vitaliyyats.sprint13.entity.Task;

public interface TaskService {
    Task addTaskToSprint(Task task, Sprint sprint);
    Task getTaskById(Long id);
}
