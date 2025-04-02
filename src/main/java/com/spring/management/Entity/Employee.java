// // package com.spring.management.Entity;

// // import jakarta.persistence.*;

// // @Entity
// // public class Employee {
    
// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;
    
// //     private String employeeName;
// //     private String employeeEmail;
// //     private String designation;

   
// //     public Employee() {}

   
// //     public Employee(Long id, String employeeName, String employeeEmail,String designation) {
// //         this.id = id;
// //         this.employeeName = employeeName;
// //         this.employeeEmail=employeeEmail;
// //         this.designation = designation;
// //     }

  
// //     public Long getId() {
// //         return id;
// //     }

// //     public void setId(Long id) {
// //         this.id = id;
// //     }

// //     public String getEmployeeName() {
// //         return employeeName;
// //     }

// //     public void setEmployeeName(String employeeName) {
// //         this.employeeName = employeeName;
// //     }
// //     public String getEmployeeEmail() {
// //         return employeeEmail;
// //     }

// //     public void setEmployeeEmail(String employeeEmail) {
// //         this.employeeEmail = employeeEmail;
// //     }

// //     public String getDesignation() {
// //         return designation;
// //     }

// //     public void setDesignation(String designation) {
// //         this.designation = designation;
// //     }
// // }


// package com.spring.management.Entity;

// import jakarta.persistence.*;

// @Entity
// public class Employee {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "admin_id")
//     private Admin admin; // Reference to Admin

//     private String name;
//     private String email;

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Admin getAdmin() {
//         return admin;
//     }

//     public void setAdmin(Admin admin) {
//         this.admin = admin;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }
// }


/// VVVV IMP//
/*package com.spring.management.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
     @JsonBackReference 
    @JoinColumn(name = "admin_id")
    private Admin admin;

    private String name;
    private String email;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Admin getAdmin() { return admin; }
    public void setAdmin(Admin admin) { this.admin = admin; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
*/

package com.spring.management.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "admin_id",nullable = false)
    @JsonBackReference  // Prevents recursion by marking the "child" side
    private Admin admin;

    private String name;
    private String email;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Admin getAdmin() { return admin; }
    public void setAdmin(Admin admin) { this.admin = admin; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
