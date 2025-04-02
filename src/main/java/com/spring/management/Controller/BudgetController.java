// package com.spring.management.Controller;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.spring.management.Entity.Budget;
// import com.spring.management.Service.BudgetService;

// import java.math.BigDecimal;
// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/budgets")
// public class BudgetController {

//     @Autowired
//     private BudgetService budgetService;

    
//     @PostMapping("/add")
//     public Budget createBudget(@RequestBody Budget budget) {
//         return budgetService.createBudget(budget);
//     }

//         @GetMapping("get/page")
//     public Page<Budget> getAllBudgets(Pageable pageable) {
//         return budgetService.getAllBudgets(pageable);
//     }

   
//     @GetMapping("get/{id}")
//     public ResponseEntity<Budget> getBudgetById(@PathVariable Long id) {
//         Optional<Budget> budget = budgetService.getBudgetById(id);
//         return budget.map(ResponseEntity::ok)
//                      .orElseGet(() -> ResponseEntity.notFound().build());
//     }

//     @PutMapping("get/{id}")
//     public ResponseEntity<Budget> updateBudget(@PathVariable Long id, @RequestBody Budget updatedBudget) {
//         try {
//             return ResponseEntity.ok(budgetService.updateBudget(id, updatedBudget));
//         } catch (RuntimeException e) {
//             return ResponseEntity.notFound().build();
//         }
//     }

    
//     @DeleteMapping("delete/{id}")
//     public ResponseEntity<Void> deleteBudget(@PathVariable Long id) {
//         budgetService.deleteBudget(id);
//         return ResponseEntity.noContent().build();
//     }

//     // (Custom JPA Method)
//     @GetMapping("/category/{category}")
//     public List<Budget> getBudgetsByCategory(@PathVariable String category) {
//         return budgetService.findByCategory(category);
//     }

//     // (JPQL Query)
//     @GetMapping("/exceeding/{amount}")
//     public List<Budget> getBudgetsExceedingAmount(@PathVariable BigDecimal amount) {
//         return budgetService.findBudgetsExceedingAmount(amount);
//     }
// }


package com.spring.management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.management.Entity.Budget;
import com.spring.management.Service.BudgetService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    // Create Budget
    @PostMapping("/add")
    public Budget createBudget(@RequestBody Budget budget) {
        return budgetService.createBudget(budget);
    }

    // Get All Budgets with Pagination
    @GetMapping("get/page")
    public Page<Budget> getAllBudgets(Pageable pageable) {
        return budgetService.getAllBudgets(pageable);
    }

    // Get Budget by ID
    @GetMapping("get/{id}")
    public ResponseEntity<Budget> getBudgetById(@PathVariable Long id) {
        Optional<Budget> budget = budgetService.getBudgetById(id);
        return budget.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update Budget
    @PutMapping("/update/{id}")
    public ResponseEntity<Budget> updateBudget(@PathVariable Long id, @RequestBody Budget updatedBudget) {
        try {
            return ResponseEntity.ok(budgetService.updateBudget(id, updatedBudget));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete Budget
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
        return ResponseEntity.noContent().build();
    }

    // Custom Query - Get Budgets by Category
    @GetMapping("/category/{category}")
    public List<Budget> getBudgetsByCategory(@PathVariable String category) {
        return budgetService.findByCategory(category);
    }

    // Custom JPQL Query - Get Budgets Exceeding Amount
    @GetMapping("/exceeding/{amount}")
    public List<Budget> getBudgetsExceedingAmount(@PathVariable BigDecimal amount) {
        return budgetService.findBudgetsExceedingAmount(amount);
    }
}
