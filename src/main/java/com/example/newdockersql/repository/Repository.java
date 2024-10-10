package com.example.newdockersql.repository;

import com.example.newdockersql.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Students,Long> {
    Students findByEmail(String email);
}
