package com.spring.management.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.management.Entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

  
    Page<Task> findByIsCompleted(boolean isCompleted, Pageable pageable);

    
}