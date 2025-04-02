// // // package com.spring.management.Service;


// // // import org.springframework.beans.factory.annotation.Autowired;
// // // import org.springframework.data.domain.Page;
// // // import org.springframework.data.domain.Pageable;
// // // import org.springframework.stereotype.Service;

// // // import com.spring.management.Entity.Budget;
// // // import com.spring.management.Repository.BudgetRepository;

// // // import java.math.BigDecimal;
// // // import java.util.List;
// // // import java.util.Optional;

// // // @Service
// // // public class BudgetService {

// // //     @Autowired
// // //     private BudgetRepository budgetRepository;

// // //     public Budget createBudget(Budget budget) {
// // //         return budgetRepository.save(budget);
// // //     }

// // //     public Page<Budget> getAllBudgets(Pageable pageable) {
// // //         return budgetRepository.findAll(pageable);
// // //     }

// // //     public Optional<Budget> getBudgetById(Long id) {
// // //         return budgetRepository.findById(id);
// // //     }

// // //     public Budget updateBudget(Long id, Budget updatedBudget) {
// // //         return budgetRepository.findById(id).map(budget -> {
// // //             budget.setCategory(updatedBudget.getCategory());
// // //             budget.setAllocatedAmount(updatedBudget.getAllocatedAmount());
// // //             budget.setSpentAmount(updatedBudget.getSpentAmount());
// // //             return budgetRepository.save(budget);
// // //         }).orElseThrow(() -> new RuntimeException("Budget not found"));
// // //     }

// // //     public void deleteBudget(Long id) {
// // //         budgetRepository.deleteById(id);
// // //     }

// // //     public List<Budget> findByCategory(String category) {
// // //         return budgetRepository.findByCategory(category);
// // //     }

// // //     public List<Budget> findBudgetsExceedingAmount(BigDecimal amount) {
// // //         return budgetRepository.findBudgetsExceedingAmount(amount);
// // //     }
// // // }


// // package com.spring.management.Service;

// // import com.spring.management.Entity.Budget;
// // import com.spring.management.Repository.BudgetRepository;
// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.data.domain.Page;
// // import org.springframework.data.domain.Pageable;
// // import org.springframework.stereotype.Service;

// // import java.math.BigDecimal;
// // import java.util.List;
// // import java.util.Optional;

// // @Service
// // public class BudgetService {

// //     @Autowired
// //     private BudgetRepository budgetRepository;

// //     public Budget createBudget(Budget budget) {
// //         return budgetRepository.save(budget);
// //     }

// //     public Optional<Budget> getBudgetById(Long id) {
// //         return budgetRepository.findById(id);
// //     }

// //     public void deleteBudget(Long id) {
// //         budgetRepository.deleteById(id);
// //     }

// //     public Page<Budget> getAllBudgets(Pageable pageable) {
// //         return budgetRepository.findAll(pageable);
// //     }
    
// //     public List<Budget> findByCategory(String category) {
// //         return budgetRepository.findByCategory(category);
// //     }
    
    
    
// // }


// package com.spring.management.Service;

// import com.spring.management.Entity.Budget;
// import com.spring.management.Repository.BudgetRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.stereotype.Service;

// import java.math.BigDecimal;
// import java.util.List;
// import java.util.Optional;

// @Service
// public class BudgetService {

//     @Autowired
//     private BudgetRepository budgetRepository;

//     // Create a new Budget
//     public Budget createBudget(Budget budget) {
//         return budgetRepository.save(budget);
//     }

//     // Get Budget by ID
//     public Optional<Budget> getBudgetById(Long id) {
//         return budgetRepository.findById(id);
//     }

//     // Delete a Budget
//     public void deleteBudget(Long id) {
//         budgetRepository.deleteById(id);
//     }

//     // Get All Budgets with Pagination
//     public Page<Budget> getAllBudgets(Pageable pageable) {
//         return budgetRepository.findAll(pageable);
//     }

//     // Find Budgets by Category
//     public List<Budget> findByCategory(String category) {
//         return budgetRepository.findByCategory(category);
//     }

//     // Update Budget by ID
//     public Budget updateBudget(Long id, Budget updatedBudget) {
//         if (budgetRepository.existsById(id)) {
//             updatedBudget.setId(id);
//             return budgetRepository.save(updatedBudget);
//         } else {
//             throw new RuntimeException("Budget not found with id: " + id);
//         }
//     }

//     // Find Budgets exceeding a specific amount
//     public List<Budget> findBudgetsExceedingAmount(BigDecimal amount) {
//         return budgetRepository.findByAllocatedAmountGreaterThan(amount);
//     }
// }



package com.spring.management.Service;

import com.spring.management.Entity.Budget;
import com.spring.management.Repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    // Create a new Budget
    public Budget createBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    // Get Budget by ID
    public Optional<Budget> getBudgetById(Long id) {
        return budgetRepository.findById(id);
    }

    // Delete a Budget
    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }

    // Get All Budgets with Pagination
    public Page<Budget> getAllBudgets(Pageable pageable) {
        return budgetRepository.findAll(pageable);
    }

    // Find Budgets by Category
    public List<Budget> findByCategory(String category) {
        return budgetRepository.findByCategory(category);
    }

    // Update Budget by ID
    public Budget updateBudget(Long id, Budget updatedBudget) {
        if (budgetRepository.existsById(id)) {
            updatedBudget.setId(id);
            return budgetRepository.save(updatedBudget);
        } else {
            throw new RuntimeException("Budget not found with id: " + id);
        }
    }

    // Find Budgets exceeding a specific amount
    public List<Budget> findBudgetsExceedingAmount(BigDecimal amount) {
        return budgetRepository.findByAllocatedAmountGreaterThan(amount);
    }
}
