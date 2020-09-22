package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// GTB: + 把 Education 放到 User 里来统一存储，这样实现挺好，不管你是有意为之，还是无意的。以后接触到 NoSQL 之后你会了解到更多。
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
