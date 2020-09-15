package com.example.demo.api;

import com.example.demo.domain.Education;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid User user) {
        userService.add(user);
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}/educations")
    public List<Education> getUserEducations(@PathVariable long id) {
        return userService.getUserEducations(id);
    }

    @PostMapping("/users/{id}/educations")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEducation(@PathVariable long id, @RequestBody @Valid Education education) {
        userService.addEducation(id, education);
    }


}
