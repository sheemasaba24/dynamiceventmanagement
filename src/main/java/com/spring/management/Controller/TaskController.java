package com.spring.management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring.management.Service.TaskService;
import com.spring.management.Entity.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /*
    @PostMapping("/add")
    public ResponseEntity<Task> createTask(@RequestParam String taskName, @RequestParam String description, @RequestParam LocalDateTime dueDate) {
        Task task = taskService.createTask(taskName, description, dueDate);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }*/
    @PostMapping("/add")
public ResponseEntity<Task> createTask(@RequestBody Task task) {
    Task savedTask = taskService.createTask(task.getTaskName(), task.getDescription(), task.getDueDate());
    return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
}


    //  pagination and sorting
    @GetMapping("/get")
    public ResponseEntity<Page<Task>> getAllTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        
        Page<Task> tasks = taskService.getAllTasks(page, size, sortBy, direction);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("put/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestParam String taskName, @RequestParam String description,
  @RequestParam LocalDateTime dueDate, @RequestParam boolean isCompleted) {
        Task task = taskService.updateTask(id, taskName, description, dueDate, isCompleted);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    // Get tasks by completion status with pagination
    @GetMapping("/status")
    public ResponseEntity<Page<Task>> getTasksByStatus(
            @RequestParam boolean isCompleted,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        
        Page<Task> tasks = taskService.findTasksByStatus(isCompleted, page, size, sortBy, direction);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
