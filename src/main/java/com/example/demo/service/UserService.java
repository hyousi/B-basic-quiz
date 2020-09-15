package com.example.demo.service;

import com.example.demo.domain.Education;
import com.example.demo.domain.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(long id) {
        User user = userRepository.findById(id);

        if (user == null) {
            throw new UserNotFoundException();
        }

        return user;
    }

    public List<Education> getUserEducations(long id) {
        return getUser(id).getEducationList();
    }

    public void add(User user) {
        userRepository.add(user);
    }

    public void addEducation(long id, Education education) {
        getUser(id).addEducation(education);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
