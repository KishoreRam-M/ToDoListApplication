package com.Project.ToDoApplication.repo;

import com.Project.ToDoApplication.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task,Long>
{

}
