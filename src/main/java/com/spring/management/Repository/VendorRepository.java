package com.spring.management.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.management.Entity.Vendor;

import java.util.List;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {

    // Custom JPA Query
    List<Vendor> findByCategory(String category);

    // JPQL Query
    @Query("SELECT v FROM Vendor v WHERE LOWER(v.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Vendor> searchByName(String keyword);

    // Pagination and Sorting 
    //Page<Vendor> findAll(Pageable pageable);
}

