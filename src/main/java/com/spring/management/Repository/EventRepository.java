package com.spring.management.Repository;

import com.spring.management.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    
    List<Event> findByEventNameContains(String eventName);

    
}

