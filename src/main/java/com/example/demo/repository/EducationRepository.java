package com.example.demo.repository;

import com.example.demo.domain.Education;
import com.example.demo.domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Integer> {

    List<Education> findAllByUser(User user);

}
