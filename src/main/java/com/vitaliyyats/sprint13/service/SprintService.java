package com.vitaliyyats.sprint13.service;

import com.vitaliyyats.sprint13.entity.Marathon;
import com.vitaliyyats.sprint13.entity.Sprint;

import java.util.List;

public interface SprintService {
    List<Sprint> getSprintsByMarathonId(Long id);
    boolean addSprintToMarathon(Sprint sprint, Marathon marathon);
    Sprint getSprintById(Long id);
    boolean updateSprint(Sprint sprint);

}
