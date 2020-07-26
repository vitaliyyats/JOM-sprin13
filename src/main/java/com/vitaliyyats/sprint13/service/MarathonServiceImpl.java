package com.vitaliyyats.sprint13.service;

import com.vitaliyyats.sprint13.entity.Marathon;
import com.vitaliyyats.sprint13.repository.MarathonRepository;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MarathonServiceImpl implements MarathonService {

    private MarathonRepository marathonRepository;

    @Autowired
    public MarathonServiceImpl(MarathonRepository marathonRepository) {
        this.marathonRepository = marathonRepository;
    }

    @Override
    public Marathon getMarathonById(Long id) {
        return marathonRepository.getMarathonById(id);
    }

    @Override
    public List<Marathon> getAll() {
        return marathonRepository.findAll();
    }

    @Override
    public void deleteMarathonById(Long id) {
        marathonRepository.deleteMarathonById(id);
    }

    @Override
    public Marathon createOrUpdate(Marathon marathon) {
        Validate.notNull(marathon.getTitle(), "Title must be not null");
        return marathonRepository.save(marathon);
    }

}
