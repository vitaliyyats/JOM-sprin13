package com.vitaliyyats.sprint13.repository;

import com.vitaliyyats.sprint13.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {
    List<Sprint> getSprintsByMarathonId(Long id);

    Sprint getSprintById(Long id);
}
