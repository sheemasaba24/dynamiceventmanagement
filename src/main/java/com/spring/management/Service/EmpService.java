// package com.spring.management.Service;

// import com.spring.management.Entity.Employee;
// import com.spring.management.Repository.EmployeeRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class EmpService {

//     @Autowired
//     private EmployeeRepository employeeRepository;

   
//     public Employee createEmployee(Employee employee) {
//         return employeeRepository.save(employee);
//     }

   
//     public Page<Employee> getAllEmployees(Pageable pageable) {
//         return employeeRepository.findAll(pageable);
//     }

//     public Employee getEmployeeById(Long id) {
//         Optional<Employee> employee = employeeRepository.findById(id);
//         return employee.orElse(null); 
//     }

    
//     public Employee updateEmployee(Long id, Employee updatedEmployee) {
//         if (employeeRepository.existsById(id)) {
//             updatedEmployee.setId(id); 
//             return employeeRepository.save(updatedEmployee);
//         }
//         return null; 
//     }

  
//     public String deleteEmployee(Long id) {
//         if (employeeRepository.existsById(id)) {
//             employeeRepository.deleteById(id);
//             return "Employee deleted successfully.";
//         }
//         return "Employee not found.";
//     }
// }


// package com.spring.management.Service;

// import com.spring.management.Entity.Employee;
// import com.spring.management.Entity.Admin;
// import com.spring.management.Repository.EmployeeRepository;
// import com.spring.management.Repository.AdminRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class EmpService {

//     @Autowired
//     private EmployeeRepository employeeRepository;

//     @Autowired
//     private AdminRepository adminRepository;

//     public Employee saveEmployee(Employee employee) {
//         return employeeRepository.save(employee);
//     }

//     // GET Employee by ID
//     public Employee getEmployeeById(Long id) {
//         return employeeRepository.findById(id).orElse(null); // Return null if not found
//     }

//     // GET All Employees
//     public Iterable<Employee> getAllEmployees() {
//         return employeeRepository.findAll();
//     }

//     // UPDATE Employee
//     public Employee updateEmployee(Long id, Employee employee) {
//         if (employeeRepository.existsById(id)) {
//             employee.setId(id); // Ensure correct ID for update
//             return employeeRepository.save(employee);
//         } else {
//             return null; // Employee not found
//         }
//     }

//     // DELETE Employee
//     public String deleteEmployee(Long id) {
//         if (employeeRepository.existsById(id)) {
//             employeeRepository.deleteById(id);
//             return "Employee deleted successfully!";
//         } else {
//             return "Employee not found.";
//         }
//     }
// }


package com.spring.management.Service;

import com.spring.management.Entity.Employee;
import com.spring.management.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // CREATE Employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // GET Employee by ID
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    // GET All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // UPDATE Employee
    public Employee updateEmployee(Long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        }
        return null;
    }

    // DELETE Employee
    public String deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Employee deleted successfully!";
        }
        return "Employee not found.";
    }
}
