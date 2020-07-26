package com.vitaliyyats.sprint13.service;

import com.vitaliyyats.sprint13.entity.Marathon;
import com.vitaliyyats.sprint13.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getUserById(Long id);

    User createOrUpdateUser(User user);

    List<User> getAllByRole(String role);

    boolean addUserToMarathon(User user, Marathon marathon);
}
