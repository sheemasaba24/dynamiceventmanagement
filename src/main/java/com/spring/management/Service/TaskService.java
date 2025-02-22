package com.spring.management.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.spring.management.Repository.TaskRepository;
import com.spring.management.Entity.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

   
    public Task createTask(String taskName, String description, LocalDateTime dueDate) {
        Task task = new Task(taskName, description, dueDate);
        return taskRepository.save(task);
    }

    //  pagination and sorting
    public Page<Task> getAllTasks(int page, int size, String sortBy, String direction) {
        Pageable pageable = PageRequest.of(page, size, direction.equalsIgnoreCase("desc") ? 
  Pageable.unpaged().getSort().descending() : Pageable.unpaged().getSort().ascending());
        return taskRepository.findAll(pageable);
    }


    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

   
    public Task updateTask(Long id, String taskName, String description, LocalDateTime dueDate, boolean isCompleted) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));
        task.setTaskName(taskName);
        task.setDescription(description);
        task.setDueDate(dueDate);
        task.setCompleted(isCompleted);
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    //  pagination
    public Page<Task> findTasksByStatus(boolean isCompleted, int page, int size, String sortBy, String direction) {
        Pageable pageable = PageRequest.of(page, size, direction.equalsIgnoreCase("desc") ? 
       Pageable.unpaged().getSort().descending() : Pageable.unpaged().getSort().ascending());
        return taskRepository.findByIsCompleted(isCompleted, pageable);
    }

    
}
