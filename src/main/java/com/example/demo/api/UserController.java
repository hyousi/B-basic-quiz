package com.example.demo.api;

import com.example.demo.domain.Education;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public User get(@PathVariable long id) {
        return userService.get(id);
    }

    @GetMapping("/users/{id}/educations")
    public List<Education> getUserEducations(@PathVariable long id) {
        return userService.getUserEducations(id);
    }


}
