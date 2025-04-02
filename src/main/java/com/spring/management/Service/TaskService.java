package com.spring.management.Service;

import com.spring.management.Entity.Task;
import com.spring.management.Entity.Vendor;
import com.spring.management.Repository.TaskRepository;
import com.spring.management.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private VendorRepository vendorRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Transactional
    public Task addVendorsToTask(Long taskId, List<Long> vendorIds) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        List<Vendor> vendors = vendorRepository.findAllById(vendorIds);
        task.getVendors().addAll(vendors);
        return taskRepository.save(task); // This will commit the changes
    }

    public Task getTaskWithVendors(Long taskId) {
        return taskRepository.findByIdWithVendors(taskId).orElse(null);
    }

    public Page<Task> getAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    @Transactional
    public Task updateTask(Long id, Task updatedTask) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTaskName(updatedTask.getTaskName());
        task.setDescription(updatedTask.getDescription());
        task.setDueDate(updatedTask.getDueDate());
        task.setCompleted(updatedTask.isCompleted());
        return taskRepository.save(task); // This will commit the changes
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
