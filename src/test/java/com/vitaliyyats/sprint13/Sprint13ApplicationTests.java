package com.vitaliyyats.sprint13;

import com.vitaliyyats.sprint13.entity.Marathon;
import com.vitaliyyats.sprint13.entity.Sprint;
import com.vitaliyyats.sprint13.repository.SprintRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class Sprint13ApplicationTests {

    @Autowired
    SprintRepository sprintRepository;

    @Test
    void saveMarathonInSprint() {
        Sprint sprint = new Sprint();
        sprint.setStart(LocalDate.of(2020, 8, 23));
        sprint.setFinish(LocalDate.of(2020, 8, 25));
        sprint.setTitle("ORM. Hibernate with Spring");

        Marathon marathon = new Marathon();
        marathon.setTitle("JOM");
        sprint.setMarathon(marathon);
        sprintRepository.save(sprint);
        Assertions.assertNotNull(sprint.getId());
    }

}
