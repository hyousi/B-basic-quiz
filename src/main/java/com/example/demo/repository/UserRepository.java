package com.example.demo.repository;

import com.example.demo.domain.User;
import java.util.HashSet;
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
        if (user.getId() == null) {
            user.setId(size());
        }
        users.add(user);
    }

    public long size() {
        return users.size();
    }
}
