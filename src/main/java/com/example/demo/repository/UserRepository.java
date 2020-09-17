package com.example.demo.repository;

import com.example.demo.domain.User;
import com.example.demo.exception.UserExistsException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Repository;

// GTB: + 把 Education 放到 User 里来统一存储，这样实现挺好，不管你是有意为之，还是无意的。以后接触到 NoSQL 之后你会了解到更多。
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
        // GTB: 好奇为什么不使用 Map
        if (users.stream().map(User::getId).anyMatch(id -> user.getId().equals(id))) {
            throw new UserExistsException();
        }

        if (user.getId() == null) {
            // GTB: - id 不要通过 size 来生成，太容易出错了，想想为什么
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
