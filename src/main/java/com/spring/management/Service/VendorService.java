package com.spring.management.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.management.Entity.Vendor;
import com.spring.management.Repository.VendorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public Vendor updateVendor(Long id, Vendor updatedVendor) {
        Optional<Vendor> existingVendor = vendorRepository.findById(id);
        if (existingVendor.isPresent()) {
            Vendor vendor = existingVendor.get();
            vendor.setName(updatedVendor.getName());
            vendor.setCategory(updatedVendor.getCategory());
            vendor.setServices(updatedVendor.getServices());
            vendor.setPricing(updatedVendor.getPricing());
            return vendorRepository.save(vendor);
        } else {
            throw new RuntimeException("Vendor not found");
        }
    }

    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Vendor getVendorById(Long id) {
        return vendorRepository.findById(id).orElseThrow(() -> new RuntimeException("Vendor not found"));
    }

    public List<Vendor> findVendorsByCategory(String category) {
        return vendorRepository.findByCategory(category);
    }

    public List<Vendor> searchVendorsByName(String keyword) {
        return vendorRepository.searchByName(keyword);
    }

    
    public Page<Vendor> getVendorsWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return vendorRepository.findAll(pageable);
    }
    /*public Page<Vendor> getVendorsWithPaginationAndSorting(int page, int size, String sortBy, String sortDir) {
        org.springframework.data.domain.Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return vendorRepository.findAll(pageable);
    }*/
    public List<Vendor> sortByPricingDesc() {
        return vendorRepository.findAll(Sort.by("pricing").descending());
    }

}
