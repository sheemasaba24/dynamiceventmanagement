
// // // package com.spring.management.Entity;


// // // import jakarta.persistence.*;

// // // @Entity
// // // @Table(name = "admins")
// // // public class Admin {

// // //     @Id
// // //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// // //     private Long id;

// // //     @Column(nullable = false, unique = true)
// // //     private String username;

// // //     @Column(nullable = false)
// // //     private String email;

// // //     @Column(nullable = false)
// // //     private String role; // Event Manager, Vendor, Finance, etc.

// // //     @Column(nullable = false)
// // //     private String password; // In a real-world scenario, encrypt this!

// // //     // Default Constructor
// // //     public Admin() {
// // //     }

// // //     // Parameterized Constructor
// // //     public Admin(Long id, String username, String email, String role, String password) {
// // //         this.id = id;
// // //         this.username = username;
// // //         this.email = email;
// // //         this.role = role;
// // //         this.password = password;
// // //     }

// // //     // Getters and Setters
// // //     public Long getId() {
// // //         return id;
// // //     }

// // //     public void setId(Long id) {
// // //         this.id = id;
// // //     }

// // //     public String getUsername() {
// // //         return username;
// // //     }

// // //     public void setUsername(String username) {
// // //         this.username = username;
// // //     }

// // //     public String getEmail() {
// // //         return email;
// // //     }

// // //     public void setEmail(String email) {
// // //         this.email = email;
// // //     }

// // //     public String getRole() {
// // //         return role;
// // //     }

// // //     public void setRole(String role) {
// // //         this.role = role;
// // //     }

// // //     public String getPassword() {
// // //         return password;
// // //     }

// // //     public void setPassword(String password) {
// // //         this.password = password;
// // //     }

// // // }

// // package com.spring.management.Entity;

// // import com.fasterxml.jackson.annotation.JsonBackReference;
// // import jakarta.persistence.*;
// // import java.util.List;

// // @Entity
// // @Table(name = "admins")
// // public class Admin {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     @Column(nullable = false, unique = true)
// //     private String username;

// //     @Column(nullable = false)
// //     private String email;

// //     @Column(nullable = false)
// //     private String role; 

// //     @Column(nullable = false)
// //     private String password;

// //     @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
// //     @JsonBackReference // Prevents infinite recursion
// //     private List<Event> events;

// //     // Constructors
// //     public Admin() {}

// //     public Admin(Long id, String username, String email, String role, String password) {
// //         this.id = id;
// //         this.username = username;
// //         this.email = email;
// //         this.role = role;
// //         this.password = password;
// //     }

// //     // Getters and Setters
// //     public Long getId() { return id; }
// //     public void setId(Long id) { this.id = id; }

// //     public String getUsername() { return username; }
// //     public void setUsername(String username) { this.username = username; }

// //     public String getEmail() { return email; }
// //     public void setEmail(String email) { this.email = email; }

// //     public String getRole() { return role; }
// //     public void setRole(String role) { this.role = role; }

// //     public String getPassword() { return password; }
// //     public void setPassword(String password) { this.password = password; }

// //     public List<Event> getEvents() { return events; }
// //     public void setEvents(List<Event> events) { this.events = events; }
// // }


// package com.spring.management.Entity;

// import jakarta.persistence.*;

// import java.util.List;

// @Entity
// public class Admin {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String username;
//     private String email;
//     private String role;
//     private String password;

//     @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//     private List<Employee> employees;

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getUsername() {
//         return username;
//     }

//     public void setUsername(String username) {
//         this.username = username;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public String getRole() {
//         return role;
//     }

//     public void setRole(String role) {
//         this.role = role;
//     }

//     public String getPassword() {
//         return password;
//     }

//     public void setPassword(String password) {
//         this.password = password;
//     }

//     public List<Employee> getEmployees() {
//         return employees;
//     }

//     public void setEmployees(List<Employee> employees) {
//         this.employees = employees;
//     }
// }


//VVVVVVVV IMP
/*package com.spring.management.Entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String role;
    private String password;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     @JsonManagedReference 
    private List<Employee> employees;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }
}
*/


package com.spring.management.Entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String role;
    private String password;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonManagedReference  // Prevents recursion by marking the "parent" side
    private List<Employee> employees;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }
}
