package com.example.demo.service;

import com.example.demo.domain.Education;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User get(long id) {
        return userRepository.findById(id);
    }

    public List<Education> getUserEducations(long id) {
        return userRepository.findById(id).getEducationList();
    }

    public void add(User user) {
        userRepository.add(user);
    }
}
