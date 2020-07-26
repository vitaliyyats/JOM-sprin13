package com.vitaliyyats.sprint13.service;

import com.vitaliyyats.sprint13.entity.Marathon;

import java.util.List;

public interface MarathonService {
    Marathon getMarathonById(Long id);

    Marathon createOrUpdate(Marathon marathon);

    List<Marathon> getAll();

    void deleteMarathonById(Long id);
}
