package com.spring.management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.management.Entity.Admin;
import com.spring.management.Service.AdminService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // ✅ Create Admin
    @PostMapping("/add")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        return ResponseEntity.ok(adminService.saveAdmin(admin));
    }

    // ✅ Get Admin by ID
    @GetMapping("get/{id}")
    public ResponseEntity<Optional<Admin>> getAdminById(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getAdminById(id));
    }

    // ✅ Get All Admins (Pagination & Sorting)
    @GetMapping("/get")
    public ResponseEntity<Page<Admin>> getAllAdmins(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        return ResponseEntity.ok(adminService.getAllAdmins(page, size, sortBy, sortDir));
    }

    // ✅ Get Admins by Role
    @GetMapping("/role/{role}")
    public ResponseEntity<Page<Admin>> getAdminsByRole(
            @PathVariable String role,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(adminService.getAdminsByRole(role, page, size));
    }

    // ✅ Get Admins by Email Domain
    @GetMapping("/email-domain")
    public ResponseEntity<List<Admin>> getAdminsByEmailDomain(@RequestParam String domain) {
        return ResponseEntity.ok(adminService.getAdminsByEmailDomain(domain));
    }

    // ✅ Update Admin
    @PutMapping("update/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        admin.setId(id); // Ensure the ID is set for update
        return ResponseEntity.ok(adminService.saveAdmin(admin));
    }

    // ✅ Delete Admin
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok("Admin deleted successfully!");
    }
}

