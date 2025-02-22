package com.spring.management.Service;
import com.spring.management.Entity.Guest;
import com.spring.management.Repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


@Service
public class GuestService {
    
    @Autowired
    private GuestRepository guestRepository;

    
    public Guest saveGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    //  pagination and sorting
    public Page<Guest> getAllGuests(Pageable pageable) {
        return guestRepository.findAll(pageable);
    }

   
    public Optional<Guest> getGuestById(Long id) {
        return guestRepository.findById(id);
    }

    
    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }

    //(Custom Query Example)
    public List<Guest> findGuestsByName(String name) {
        return guestRepository.findByNameContains(name);
    }
}
