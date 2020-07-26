package com.vitaliyyats.sprint13.service;

import com.vitaliyyats.sprint13.entity.Progress;
import com.vitaliyyats.sprint13.entity.Task;
import com.vitaliyyats.sprint13.entity.User;

import java.util.List;

public interface ProgressService {
    Progress getProgressById(Long progressId);

    Progress addTaskForStudent(Task task, User user);

    Progress addOrUpdateProgress(Progress progress);

    boolean setStatus(Progress.TaskStatus taskStatus, Progress progress);

    List<Progress> allProgressByUserIdAndMarathonId(Long userId, Long marathonId);

    List<Progress> allProgressByUserIdAndSprintId(Long userId, Long sprintId);
}
