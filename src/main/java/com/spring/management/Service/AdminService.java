package com.spring.management.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.management.Entity.Admin;
import com.spring.management.Repository.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // ✅ Create or Update Admin
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // ✅ Get Admin by ID
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    // ✅ Get All Admins with Pagination & Sorting
    public Page<Admin> getAllAdmins(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return adminRepository.findAll(pageable);
    }

    // ✅ Get Admin by Role (Paginated)
    public Page<Admin> getAdminsByRole(String role, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return adminRepository.findByRole(role, pageable);
    }

    // ✅ Custom Query - Get Admins by Email Domain
    public List<Admin> getAdminsByEmailDomain(String domain) {
        return adminRepository.findAdminsByEmailDomain(domain);
    }

    // ✅ Delete Admin
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
