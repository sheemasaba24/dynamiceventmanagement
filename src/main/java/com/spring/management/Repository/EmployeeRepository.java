// package com.spring.management.Repository;

// import com.spring.management.Entity.Employee;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface EmployeeRepository extends JpaRepository<Employee, Long> {
// }



package com.spring.management.Repository;

import com.spring.management.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom queries can be added here if needed
}
