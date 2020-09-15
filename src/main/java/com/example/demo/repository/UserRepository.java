package com.example.demo.repository;

import com.example.demo.domain.User;
import com.example.demo.exception.UserExistsException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private Set<User> users;

    public UserRepository() {
        this.users = new HashSet<>();
    }

    public User findById(long id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void add(User user) {
        if (users.stream().map(User::getId).anyMatch(id -> user.getId().equals(id))) {
            throw new UserExistsException();
        }

        if (user.getId() == null) {
            user.setId(size());
        }

        users.add(user);
    }

    public long size() {
        return users.size();
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }
}
