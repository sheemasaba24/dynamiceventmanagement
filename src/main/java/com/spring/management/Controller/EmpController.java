package com.spring.management.Controller;

import com.spring.management.Entity.Employee;
import com.spring.management.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return empService.createEmployee(employee);
    }

    @GetMapping("/get")
    public ResponseEntity<Page<Employee>> getAllEmployees(Pageable pageable) {
        Page<Employee> employees = empService.getAllEmployees(pageable);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("get/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return empService.getEmployeeById(id);
    }

    @PutMapping("put/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return empService.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        String response = empService.deleteEmployee(id);
        return ResponseEntity.ok(response);
    }
}
 