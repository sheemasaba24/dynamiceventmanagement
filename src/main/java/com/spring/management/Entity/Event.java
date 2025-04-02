// package com.spring.management.Entity;

// import jakarta.persistence.*;

// @Entity
// public class Event {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY) 
//     private Long id;

//     private String eventName;
//     private String eventDescription;
//     private String eventLocation;
//     private String eventDate;

   
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getEventName() {
//         return eventName;
//     }

//     public void setEventName(String eventName) {
//         this.eventName = eventName;
//     }

//     public String getEventDescription() {
//         return eventDescription;
//     }

//     public void setEventDescription(String eventDescription) {
//         this.eventDescription = eventDescription;
//     }

//     public String getEventLocation() {
//         return eventLocation;
//     }

//     public void setEventLocation(String eventLocation) {
//         this.eventLocation = eventLocation;
//     }

//     public String getEventDate() {
//         return eventDate;
//     }

//     public void setEventDate(String eventDate) {
//         this.eventDate = eventDate;
//     }
// }

//BUDGET AND EVENT VERY IMPORTANT //
/*package com.spring.management.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String eventName;
    private String eventDescription;
    private String eventLocation;
    private String eventDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "budget_id", referencedColumnName = "id", unique = true)
    @JsonManagedReference 
    private Budget budget;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }
}

*/
package com.spring.management.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String eventName;
    private String eventDescription;
    private String eventLocation;
    private String eventDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "budget_id", referencedColumnName = "id", unique = true)
    @JsonManagedReference 
    private Budget budget;

    

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public String getEventDescription() { return eventDescription; }
    public void setEventDescription(String eventDescription) { this.eventDescription = eventDescription; }

    public String getEventLocation() { return eventLocation; }
    public void setEventLocation(String eventLocation) { this.eventLocation = eventLocation; }

    public String getEventDate() { return eventDate; }
    public void setEventDate(String eventDate) { this.eventDate = eventDate; }

    public Budget getBudget() { return budget; }
    public void setBudget(Budget budget) { this.budget = budget; }

    
}
