package com.vitaliyyats.sprint13.service;

import com.vitaliyyats.sprint13.entity.Marathon;
import com.vitaliyyats.sprint13.entity.User;
import com.vitaliyyats.sprint13.repository.MarathonRepository;
import com.vitaliyyats.sprint13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private MarathonRepository marathonRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setMarathonRepository(MarathonRepository marathonRepository) {
        this.marathonRepository = marathonRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User createOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllByRole(String role) {
        return userRepository.getAllByRole(User.Role.valueOf(role.toUpperCase()));
    }

    @Override
    public boolean addUserToMarathon(User user, Marathon marathon) {
        Marathon existedMarathon = marathonRepository.getOne(marathon.getId());
        existedMarathon.getUsers().add(user);
        marathonRepository.save(existedMarathon);
        return true;
    }
}
