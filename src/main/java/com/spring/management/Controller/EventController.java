// package com.spring.management.Controller;

// import com.spring.management.Entity.Event;
// import com.spring.management.Service.EventService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;

// import java.util.Optional;

// @RestController
// @RequestMapping("/events")
// public class EventController {

//     @Autowired
//     private EventService eventService;

    
//     @PostMapping("/add")
//     public Event addEvent(@RequestBody Event event) {
//         return eventService.saveEvent(event);
//     }

//     //  Pagination and Sorting
//     @GetMapping("/get")
//     public ResponseEntity<Page<Event>> getAllEvents(Pageable pageable) {
//         Page<Event> events = eventService.getAllEvents(pageable);
//         return ResponseEntity.ok(events);
//     }

    
//     @GetMapping("get/{id}")
//     public ResponseEntity<Event> getEventById(@PathVariable Long id) {
//         Optional<Event> event = eventService.getEventById(id);
//         return event.map(ResponseEntity::ok)
//                     .orElseGet(() -> ResponseEntity.notFound().build());
//     }

    
//     @PutMapping("put/{id}")
//     public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
//         return eventService.getEventById(id)
//                 .map(existingEvent -> {
//                     updatedEvent.setId(id);  // Ensure ID is set for update
//                     Event savedEvent = eventService.saveEvent(updatedEvent);
//                     return ResponseEntity.ok(savedEvent);
//                 })
//                 .orElseGet(() -> ResponseEntity.notFound().build());
//     }

    
//     @DeleteMapping("delete/{id}")
//     public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
//         eventService.getEventById(id)
//                 .ifPresentOrElse(event -> {
//                     eventService.deleteEvent(id);
//                 }, () -> ResponseEntity.notFound().build());
//         return ResponseEntity.ok("Event deleted successfully.");
//     }
// }


//EVENT AND BUDGET //
package com.spring.management.Controller;

import com.spring.management.Entity.Event;
import com.spring.management.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        Event savedEvent = eventService.saveEvent(event);
        return ResponseEntity.ok(savedEvent);
    }

    @GetMapping("/get")
    public ResponseEntity<Page<Event>> getAllEvents(Pageable pageable) {
        Page<Event> events = eventService.getAllEvents(pageable);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Optional<Event> event = eventService.getEventById(id);
        return event.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update Event
    @PutMapping("/update/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
        return eventService.getEventById(id)
                .map(existingEvent -> {
                    updatedEvent.setId(id); // Ensure the ID remains the same
                    Event savedEvent = eventService.saveEvent(updatedEvent);
                    return ResponseEntity.ok(savedEvent);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Event
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        return eventService.getEventById(id)
                .map(event -> {
                    eventService.deleteEvent(id);
                    return ResponseEntity.ok("Event deleted successfully.");
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
