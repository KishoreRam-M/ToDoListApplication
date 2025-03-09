package com.Project.ToDoApplication.service;

import com.Project.ToDoApplication.model.Task;
import com.Project.ToDoApplication.repo.TaskRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepo repo;

    public List<Task> getAllTask() {
        return repo.findAll();
    }

    public void createTask(String taskName) {
        Task task = new Task();
        task.setTask_name(taskName);
        task.setStatus(false);
        repo.save(task);
    }

    public void killTask(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            System.out.println("There is no task with ID: " + id);
        }
    }

    public void toggleTask(long id) {
        Optional<Task> optionalTask = repo.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(true);
            repo.save(task);
        } else {
            System.out.println("Task not found with ID: " + id);
        }
    }
}
