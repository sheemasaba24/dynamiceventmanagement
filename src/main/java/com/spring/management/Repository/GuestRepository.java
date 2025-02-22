package com.spring.management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.management.Entity.Guest;
import java.util.List;
public interface GuestRepository extends JpaRepository<Guest, Long> {

    List<Guest> findByNameContains(String name);

    
}
