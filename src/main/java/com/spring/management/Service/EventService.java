// package com.spring.management.Service;

// import com.spring.management.Entity.Event;
// import com.spring.management.Repository.EventRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class EventService {

//     @Autowired
//     private EventRepository eventRepository;

   
//     public Event saveEvent(Event event) {
        
//         if (event.getId() == null) {
           
//             return eventRepository.save(event);  
//         } else {
            
//             if (eventRepository.existsById(event.getId())) {
//                 return eventRepository.save(event);  
//             } else {
//                 return null;  
//             }
//         }
//     }

//     // Pagination and Sorting
//     public Page<Event> getAllEvents(Pageable pageable) {
//         return eventRepository.findAll(pageable);
//     }


//     public Optional<Event> getEventById(Long id) {
//         return eventRepository.findById(id);
//     }

//     public String deleteEvent(Long id) {
//         if (eventRepository.existsById(id)) {
//             eventRepository.deleteById(id);
//             return "Event deleted successfully.";
//         }
//         return "Event not found.";
//     }

//     //  (Custom Query Example)
//     public List<Event> findEventsByName(String name) {
//         return eventRepository.findByEventNameContains(name);
//     }
// }

package com.spring.management.Service;

import com.spring.management.Entity.Event;
import com.spring.management.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public Page<Event> getAllEvents(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
