// // // package com.spring.management.Controller;

// // // import com.spring.management.Entity.Employee;
// // // import com.spring.management.Service.EmpService;
// // // import org.springframework.beans.factory.annotation.Autowired;
// // // import org.springframework.http.ResponseEntity;
// // // import org.springframework.web.bind.annotation.*;
// // // import org.springframework.data.domain.Page;
// // // import org.springframework.data.domain.Pageable;

// // // import java.util.List;

// // // @RestController
// // // @RequestMapping("/employees")
// // // public class EmpController {

// // //     @Autowired
// // //     private EmpService empService;

// // //     @PostMapping("/add")
// // //     public Employee addEmployee(@RequestBody Employee employee) {
// // //         return empService.createEmployee(employee);
// // //     }

// // //     @GetMapping("/get")
// // //     public ResponseEntity<Page<Employee>> getAllEmployees(Pageable pageable) {
// // //         Page<Employee> employees = empService.getAllEmployees(pageable);
// // //         return ResponseEntity.ok(employees);
// // //     }

// // //     @GetMapping("get/{id}")
// // //     public Employee getEmployeeById(@PathVariable Long id) {
// // //         return empService.getEmployeeById(id);
// // //     }

// // //     @PutMapping("put/{id}")
// // //     public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
// // //         return empService.updateEmployee(id, updatedEmployee);
// // //     }

// // //     @DeleteMapping("delete/{id}")
// // //     public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
// // //         String response = empService.deleteEmployee(id);
// // //         return ResponseEntity.ok(response);
// // //     }
// // // }


// // package com.spring.management.Controller;

// // import com.spring.management.Entity.Employee;
// // import com.spring.management.Service.EmpService;
// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.http.ResponseEntity;
// // import org.springframework.web.bind.annotation.*;

// // @RestController
// // @RequestMapping("/employees")
// // public class EmpController {

// //     @Autowired
// //     private EmpService empService;

// //     @PostMapping("/add")
// //     public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
// //         Employee savedEmployee = empService.saveEmployee(employee);
// //         return ResponseEntity.ok(savedEmployee);
// //     }

// //     // READ Employee by ID
// //     @GetMapping("/{id}")
// //     public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
// //         Employee employee = empService.getEmployeeById(id);
// //         return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
// //     }

// //     // READ All Employees
// //     @GetMapping("/all")
// //     public ResponseEntity<Iterable<Employee>> getAllEmployees() {
// //         Iterable<Employee> employees = empService.getAllEmployees();
// //         return ResponseEntity.ok(employees);
// //     }

// //     // UPDATE Employee
// //     @PutMapping("/update/{id}")
// //     public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
// //         Employee updatedEmployee = empService.updateEmployee(id, employee);
// //         return updatedEmployee != null ? ResponseEntity.ok(updatedEmployee) : ResponseEntity.notFound().build();
// //     }

// //     // DELETE Employee
// //     @DeleteMapping("/delete/{id}")
// //     public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
// //         String response = empService.deleteEmployee(id);
// //         return ResponseEntity.ok(response);
// //     }
// // }


// package com.spring.management.Controller;

// import com.spring.management.Entity.Employee;
// import com.spring.management.Service.EmpService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/employees")
// public class EmpController {

//     @Autowired
//     private EmpService empService;

//     // CREATE Employee
//     @PostMapping("/add")
//     public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
//         Employee savedEmployee = empService.saveEmployee(employee);
//         return ResponseEntity.ok(savedEmployee);
//     }

//     // ✅ FIXED: Use `/employees/all` instead of `/employees/get`
//     @GetMapping("/all")
//     public ResponseEntity<List<Employee>> getAllEmployees() {
//         List<Employee> employees = empService.getAllEmployees();
//         return ResponseEntity.ok(employees);
//     }

//     // GET Employee by ID (Must be a number)
//     @GetMapping("/{id}")
//     public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//         Employee employee = empService.getEmployeeById(id);
//         return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
//     }

//     // UPDATE Employee
//     @PutMapping("/update/{id}")
//     public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
//         Employee updatedEmployee = empService.updateEmployee(id, employee);
//         return updatedEmployee != null ? ResponseEntity.ok(updatedEmployee) : ResponseEntity.notFound().build();
//     }

//     // DELETE Employee
//     @DeleteMapping("/delete/{id}")
//     public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
//         String response = empService.deleteEmployee(id);
//         return ResponseEntity.ok(response);
//     }
// }


package com.spring.management.Controller;

import com.spring.management.Entity.Employee;
import com.spring.management.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmpController {

    @Autowired
    private EmpService empService;

    // CREATE Employee
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = empService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    // GET All Employees
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = empService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // GET Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = empService.getEmployeeById(id);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    // UPDATE Employee
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = empService.updateEmployee(id, employee);
        return updatedEmployee != null ? ResponseEntity.ok(updatedEmployee) : ResponseEntity.notFound().build();
    }

    // DELETE Employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        String response = empService.deleteEmployee(id);
        return ResponseEntity.ok(response);
    }
}
