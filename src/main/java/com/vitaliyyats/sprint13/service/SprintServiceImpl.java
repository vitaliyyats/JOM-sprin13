package com.vitaliyyats.sprint13.service;

import com.vitaliyyats.sprint13.entity.Marathon;
import com.vitaliyyats.sprint13.entity.Sprint;
import com.vitaliyyats.sprint13.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SprintServiceImpl implements SprintService {

    private SprintRepository sprintRepository;

    @Autowired
    public SprintServiceImpl(SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }

    @Override
    public List<Sprint> getSprintsByMarathonId(Long id) {
        return sprintRepository.getSprintsByMarathonId(id);
    }

    @Override
    public Sprint getSprintById(Long id) {
        return sprintRepository.getSprintById(id);
    }

    @Override
    public boolean addSprintToMarathon(Sprint sprint, Marathon marathon) {
        Sprint newSprint = new Sprint();
        newSprint.setTitle(sprint.getTitle());
        newSprint.setMarathon(marathon);
        newSprint.setStart(sprint.getStart());
        newSprint.setFinish(sprint.getFinish());
        sprintRepository.save(newSprint);
        return true;
    }


    @Override
    public boolean updateSprint(Sprint sprint) {
        Sprint newSprint = new Sprint();
        newSprint.setStart(sprint.getStart());
        newSprint.setFinish(sprint.getFinish());
        newSprint.setTitle(sprint.getTitle());
        if (sprint.getMarathon() != null) {
            newSprint.setMarathon(sprint.getMarathon());
        }
        sprintRepository.save(newSprint);
        return true;
    }
}
