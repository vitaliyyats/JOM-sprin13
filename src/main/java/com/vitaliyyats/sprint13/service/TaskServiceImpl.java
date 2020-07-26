package com.vitaliyyats.sprint13.service;

import com.vitaliyyats.sprint13.entity.Sprint;
import com.vitaliyyats.sprint13.entity.Task;
import com.vitaliyyats.sprint13.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task addTaskToSprint(Task task, Sprint sprint) {
        Task newTask = new Task();
        newTask.setCreated(task.getCreated());
        newTask.setTitle(task.getTitle());
        newTask.setSprint(sprint);
        if (task.getUpdated() != null) {
            newTask.setUpdated(task.getUpdated());
        }
        return taskRepository.save(newTask);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.getTaskById(id);
    }
}
