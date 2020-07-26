package com.vitaliyyats.sprint13.repository;

import com.vitaliyyats.sprint13.entity.Marathon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarathonRepository extends JpaRepository<Marathon, Long> {
    Marathon getMarathonById(Long id);

    void deleteMarathonById(Long id);
}
