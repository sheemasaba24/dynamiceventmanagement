package com.spring.management.Service;

import com.spring.management.Entity.Vendor;
import com.spring.management.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @Transactional
    public Vendor updateVendor(Long id, Vendor updatedVendor) {
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
        vendor.setName(updatedVendor.getName());
        vendor.setCategory(updatedVendor.getCategory());
        vendor.setServices(updatedVendor.getServices());
        vendor.setPricing(updatedVendor.getPricing());
        return vendorRepository.save(vendor); // This will commit the changes
    }

    public Vendor getVendorWithTasks(Long vendorId) {
        return vendorRepository.findByIdWithTasks(vendorId).orElse(null);
    }

    public Page<Vendor> getAllVendors(Pageable pageable) {
        return vendorRepository.findAll(pageable);
    }

    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}
