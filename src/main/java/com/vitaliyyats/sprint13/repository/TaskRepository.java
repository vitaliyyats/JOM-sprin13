package com.vitaliyyats.sprint13.repository;

import com.vitaliyyats.sprint13.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task getTaskById(Long id);
}
