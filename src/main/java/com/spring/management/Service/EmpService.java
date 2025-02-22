package com.spring.management.Service;

import com.spring.management.Entity.Employee;
import com.spring.management.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmployeeRepository employeeRepository;

   
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

   
    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null); 
    }

    
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        if (employeeRepository.existsById(id)) {
            updatedEmployee.setId(id); 
            return employeeRepository.save(updatedEmployee);
        }
        return null; 
    }

  
    public String deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Employee deleted successfully.";
        }
        return "Employee not found.";
    }
}
