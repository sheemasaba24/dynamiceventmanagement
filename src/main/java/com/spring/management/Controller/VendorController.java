package com.spring.management.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.management.Entity.Vendor;
import com.spring.management.Service.VendorService;
     
import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping("/add")
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
        return ResponseEntity.ok(vendorService.createVendor(vendor));
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable Long id, @RequestBody Vendor vendor) {
        return ResponseEntity.ok(vendorService.updateVendor(id, vendor));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
        return ResponseEntity.ok("Vendor deleted successfully");
    }

    @GetMapping("/get")
    public ResponseEntity<List<Vendor>> getAllVendors() {
        return ResponseEntity.ok(vendorService.getAllVendors());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable Long id) {
        return ResponseEntity.ok(vendorService.getVendorById(id));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Vendor>> getVendorsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(vendorService.findVendorsByCategory(category));
    }

    @GetMapping("/search")//jpql
    public ResponseEntity<List<Vendor>> searchVendorsByName(@RequestParam String keyword) {
        return ResponseEntity.ok(vendorService.searchVendorsByName(keyword));
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Vendor>> getVendorsWithPagination(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(vendorService.getVendorsWithPagination(page, size));
    }
   /*  @GetMapping("/page")
    public ResponseEntity<Page<Vendor>> getVendorsWithPaginationAndSorting(
            @RequestParam int page, 
            @RequestParam int size, 
            @RequestParam String sortBy, 
            @RequestParam(defaultValue = "asc") String sortDir) {
        return ResponseEntity.ok(vendorService.getVendorsWithPaginationAndSorting(page, size, sortBy, sortDir));
    }*/
    @GetMapping("/sort")
    public List<Vendor> sortVendorsByPricingDesc() {
        return vendorService.sortByPricingDesc();
    }
     
}
