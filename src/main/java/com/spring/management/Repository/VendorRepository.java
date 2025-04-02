package com.spring.management.Repository;

import com.spring.management.Entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {

    // Custom query to fetch a vendor with its associated tasks
    @Query("SELECT v FROM Vendor v LEFT JOIN FETCH v.tasks WHERE v.id = :vendorId")
    Optional<Vendor> findByIdWithTasks(Long vendorId);
}
