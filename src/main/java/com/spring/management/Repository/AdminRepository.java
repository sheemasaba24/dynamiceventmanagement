package com.spring.management.Repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.management.Entity.Admin;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    //  Find Admin by username
    Admin findByUsername(String username);

    //   pagination & sorting
    Page<Admin> findByRole(String role, Pageable pageable);

    // Custom JPQL Query 
    @Query("SELECT a FROM Admin a WHERE a.email LIKE %:domain%")
    List<Admin> findAdminsByEmailDomain(@Param("domain") String domain);
}
