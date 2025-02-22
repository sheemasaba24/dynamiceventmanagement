package com.spring.management.Controller;


import com.spring.management.Entity.Guest;
import com.spring.management.Service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping("/add")
    public Guest addGuest(@RequestBody Guest guest) {
        return guestService.saveGuest(guest);
    }

    @GetMapping("/get")
    public ResponseEntity<Page<Guest>> getAllGuests(Pageable pageable) {
        Page<Guest> guests = guestService.getAllGuests(pageable);
        return ResponseEntity.ok(guests);
    }

    @GetMapping("get/{id}")
public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
    Optional<Guest> guest = guestService.getGuestById(id);
    return guest.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
}

@PutMapping("put/{id}")
public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody Guest updatedGuest) {
    return guestService.getGuestById(id)
            .map(existingGuest -> {
                updatedGuest.setId(id);  
                Guest savedGuest = guestService.saveGuest(updatedGuest);
                return ResponseEntity.ok(savedGuest);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
}

@DeleteMapping("delete/{id}")
public ResponseEntity<String> deleteGuest(@PathVariable Long id) {
    guestService.getGuestById(id)
                .ifPresentOrElse(guest -> {
                    guestService.deleteGuest(id);
                }, () -> ResponseEntity.notFound().build());
    return ResponseEntity.ok("Guest deleted successfully.");
}

}
 