package com.spring.management.Controller;

import com.spring.management.Entity.Task;
import com.spring.management.Entity.Vendor;
import com.spring.management.Repository.TaskRepository;
import com.spring.management.Repository.VendorRepository;
import com.spring.management.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private VendorRepository vendorRepository;

    @PostMapping("/add")
    public ResponseEntity<Vendor> addVendor(@RequestBody Vendor vendor) {
        Set<Task> tasks = new HashSet<>();
        if (vendor.getTasks() != null) {
            for (Task task : vendor.getTasks()) {
                Task existingTask = taskRepository.findById(task.getId()).orElse(null);
                if (existingTask != null) {
                    tasks.add(existingTask);
                }
            }
        }
        vendor.setTasks(tasks);  // Set fetched tasks to vendor
        Vendor savedVendor = vendorRepository.save(vendor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVendor);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable Long id, @RequestBody Vendor updatedVendor) {
        Vendor vendor = vendorRepository.findById(id).orElse(null);
        if (vendor == null) {
            return ResponseEntity.notFound().build();
        }

        vendor.setName(updatedVendor.getName());
        vendor.setCategory(updatedVendor.getCategory());
        vendor.setServices(updatedVendor.getServices());
        vendor.setPricing(updatedVendor.getPricing());

        Set<Task> tasks = new HashSet<>();
        if (updatedVendor.getTasks() != null) {
            for (Task task : updatedVendor.getTasks()) {
                Task existingTask = taskRepository.findById(task.getId()).orElse(null);
                if (existingTask != null) {
                    tasks.add(existingTask);
                }
            }
        }
        vendor.setTasks(tasks);
        
        Vendor savedVendor = vendorRepository.save(vendor);
        return ResponseEntity.ok(savedVendor);
    }

    // @GetMapping("/get/{id}")
    // public ResponseEntity<Vendor> getVendorById(@PathVariable Long id) {
    //     return ResponseEntity.ok(vendorService.getVendorWithTasks(id));
    // }

    @GetMapping("/get/{id}")
public ResponseEntity<Vendor> getVendorById(@PathVariable Long id) {
    Vendor vendor = vendorService.getVendorWithTasks(id);
    return ResponseEntity.ok(vendor);
}


    // @GetMapping("/get")
    // public ResponseEntity<Page<Vendor>> getAllVendors(Pageable pageable) {
    //     return ResponseEntity.ok(vendorService.getAllVendors(pageable));
    // }
    @GetMapping("/get")
    public ResponseEntity<Page<Vendor>> getAllVendors(Pageable pageable) {
        System.out.println("Received sort parameter: " + pageable.getSort());
        Page<Vendor> vendors = vendorService.getAllVendors(pageable);
        return ResponseEntity.ok(vendors);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
        return ResponseEntity.ok("Vendor deleted successfully!");
    }
}
