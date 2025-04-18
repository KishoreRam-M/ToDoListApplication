package com.Project.ToDoApplication.controller;

import com.Project.ToDoApplication.model.Task;
import com.Project.ToDoApplication.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = service.getAllTask();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/create")
    public String toCreateTask(@RequestParam String task_name) {
        service.createTask(task_name);
        return "redirect:/tasks";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        service.killTask(id);
        return "redirect:/tasks";
    }

    @PostMapping("/toggle/{id}")
    public String toggleTask(@PathVariable long id) {
        service.toggleTask(id);
        return "redirect:/tasks";
    }
}
