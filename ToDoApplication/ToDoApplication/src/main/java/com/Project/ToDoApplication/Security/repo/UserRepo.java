package com.Project.ToDoApplication.Security.repo;

import com.Project.ToDoApplication.Security.model.User;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepo extends JpaRepository<User,Long> {
}
