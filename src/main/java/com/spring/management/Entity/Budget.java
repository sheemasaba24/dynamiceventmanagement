package com.spring.management.Entity;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "budgets")
public class Budget {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category; 
    private BigDecimal allocatedAmount;
    private BigDecimal spentAmount;
    private LocalDate date;//To Track the expenses

   
    public Budget() {}

   
    public Budget(Long id, String category, BigDecimal allocatedAmount, BigDecimal spentAmount, LocalDate date) {
        this.id = id;
        this.category = category;
        this.allocatedAmount = allocatedAmount;
        this.spentAmount = spentAmount;
        this.date = date;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(BigDecimal allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    public BigDecimal getSpentAmount() {
        return spentAmount;
    }

    public void setSpentAmount(BigDecimal spentAmount) {
        this.spentAmount = spentAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Calculate remaining budget dynamically
    public BigDecimal getRemainingBudget() {
        return allocatedAmount.subtract(spentAmount);
    }
}
