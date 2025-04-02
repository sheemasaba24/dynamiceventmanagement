// package com.spring.management.Controller;

// import com.spring.management.Entity.Admin;
// import com.spring.management.Service.AdminService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/admins")
// public class AdminController {

//     @Autowired
//     private AdminService adminService;

//     // CREATE Admin
//     @PostMapping("/add")
//     public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
//         Admin savedAdmin = adminService.saveAdmin(admin);
//         return ResponseEntity.ok(savedAdmin);
//     }

//     // READ Admin by ID
//     @GetMapping("/{id}")
//     public ResponseEntity<Optional<Admin>> getAdminById(@PathVariable Long id) {
//         Optional<Admin> admin = adminService.getAdminById(id);
//         return admin.isPresent() ? ResponseEntity.ok(admin) : ResponseEntity.notFound().build();
//     }

//     // READ All Admins
//     @GetMapping("/all")
//     public ResponseEntity<List<Admin>> getAllAdmins() {
//         List<Admin> admins = adminService.getAllAdmins();
//         return ResponseEntity.ok(admins);
//     }

//     // READ Admins by Role (with Pagination)
//     @GetMapping("/role/{role}")
//     public ResponseEntity<Page<Admin>> getAdminsByRole(
//             @PathVariable String role,
//             @RequestParam(defaultValue = "0") int page,
//             @RequestParam(defaultValue = "10") int size) {
//         Page<Admin> admins = adminService.getAdminsByRole(role, page, size);
//         return ResponseEntity.ok(admins);
//     }

//     // READ Admins by Email Domain
//     @GetMapping("/email-domain")
//     public ResponseEntity<List<Admin>> getAdminsByEmailDomain(@RequestParam String domain) {
//         List<Admin> admins = adminService.getAdminsByEmailDomain(domain);
//         return ResponseEntity.ok(admins);
//     }

//     // UPDATE Admin
//     @PutMapping("/update/{id}")
//     public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
//         Admin updatedAdmin = adminService.updateAdmin(id, admin);
//         return ResponseEntity.ok(updatedAdmin);
//     }

//     // DELETE Admin
//     @DeleteMapping("/delete/{id}")
//     public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
//         adminService.deleteAdmin(id);
//         return ResponseEntity.ok("Admin deleted successfully!");
//     }
// }

// package com.spring.management.Controller;

// import com.spring.management.Entity.Admin;
// import com.spring.management.Service.AdminService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/admins")
// public class AdminController {

//     @Autowired
//     private AdminService adminService;

//     // CREATE Admin
//     @PostMapping("/add")
//     public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
//         Admin savedAdmin = adminService.saveAdmin(admin);
//         return ResponseEntity.ok(savedAdmin);
//     }

//     // READ Admin by ID
//     @GetMapping("/{id}")
//     public ResponseEntity<Optional<Admin>> getAdminById(@PathVariable Long id) {
//         Optional<Admin> admin = adminService.getAdminById(id);
//         return admin.isPresent() ? ResponseEntity.ok(admin) : ResponseEntity.notFound().build();
//     }

//     // READ All Admins
//     @GetMapping("/all")
//     public ResponseEntity<List<Admin>> getAllAdmins() {
//         List<Admin> admins = adminService.getAllAdmins();
//         return ResponseEntity.ok(admins);
//     }

//     // UPDATE Admin
//     @PutMapping("/update/{id}")
//     public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
//         Admin updatedAdmin = adminService.updateAdmin(id, admin);
//         return updatedAdmin != null ? ResponseEntity.ok(updatedAdmin) : ResponseEntity.notFound().build();
//     }

//     // DELETE Admin
//     @DeleteMapping("/delete/{id}")
//     public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
//         adminService.deleteAdmin(id);
//         return ResponseEntity.ok("Admin deleted successfully!");
//     }
// }
 package com.spring.management.Controller;

import com.spring.management.Entity.Admin;
import com.spring.management.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // CREATE Admin
    @PostMapping("/add")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin savedAdmin = adminService.saveAdmin(admin);
        return ResponseEntity.ok(savedAdmin);
    }

    // READ Admin by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Admin>> getAdminById(@PathVariable Long id) {
        Optional<Admin> admin = adminService.getAdminById(id);
        return admin.isPresent() ? ResponseEntity.ok(admin) : ResponseEntity.notFound().build();
    }

    // READ All Admins
    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

   /*  // Paginated READ Admins by Role
    @GetMapping("/role")
    public ResponseEntity<Page<Admin>> getAdminsByRole(@RequestParam String role, Pageable pageable) {
        Page<Admin> admins = adminService.getAdminsByRole(role, pageable);
        return ResponseEntity.ok(admins);
    }*/
    @GetMapping("/role")
public ResponseEntity<Page<Admin>> getAdminsByRole(@RequestParam String role, Pageable pageable) {
    System.out.println("Received sort parameter: " + pageable.getSort());
    Page<Admin> admins = adminService.getAdminsByRole(role, pageable);
    return ResponseEntity.ok(admins);
}


    // Custom query - READ Admins by Email Domain
    @GetMapping("/email-domain")
    public ResponseEntity<List<Admin>> getAdminsByEmailDomain(@RequestParam String domain) {
        List<Admin> admins = adminService.getAdminsByEmailDomain(domain);
        return ResponseEntity.ok(admins);
    }

    // UPDATE Admin
    @PutMapping("/update/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        Admin updatedAdmin = adminService.updateAdmin(id, admin);
        return updatedAdmin != null ? ResponseEntity.ok(updatedAdmin) : ResponseEntity.notFound().build();
    }

    // DELETE Admin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok("Admin deleted successfully!");
    }
}
