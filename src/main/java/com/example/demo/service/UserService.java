package com.example.demo.service;

import com.example.demo.domain.Education;
import com.example.demo.domain.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.EducationRepository;
import com.example.demo.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final EducationRepository educationRepository;

    public UserService(UserRepository userRepository,
        EducationRepository educationRepository) {
        this.userRepository = userRepository;
        this.educationRepository = educationRepository;
    }


    public User getUser(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        // TODO: add DTO layer to combine user with education list.

        return userOptional.orElseThrow(UserNotFoundException::new);
    }

    public List<Education> getUserEducations(long id) {

        // TODO: add DTO layer to replace field `user` with `userId`
        return educationRepository.findAllByUser(getUser(id));
    }

    public void add(User user) {
        userRepository.save(user);
    }

    public void addEducation(long id, Education education) {
        User user = getUser(id);
        education.setUser(user);
        educationRepository.save(education);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
