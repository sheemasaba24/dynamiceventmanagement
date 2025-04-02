// // package com.spring.management.Repository;


// // import org.springframework.data.domain.Page;
// // import org.springframework.data.domain.Pageable;
// // import org.springframework.data.jpa.repository.JpaRepository;
// // import org.springframework.data.jpa.repository.Query;

// // import com.spring.management.Entity.Budget;

// // import java.math.BigDecimal;
// // import java.util.List;

// // public interface BudgetRepository extends JpaRepository<Budget, Long> {

// //     List<Budget> findByCategory(String category);

// //     @Query("SELECT b FROM Budget b WHERE b.spentAmount > :amount")
// //     List<Budget> findBudgetsExceedingAmount(BigDecimal amount);

// //     Page<Budget> findAll(Pageable pageable);
// // }


// package com.spring.management.Repository;

// import com.spring.management.Entity.Budget;

// import java.math.BigDecimal;
// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
// public interface BudgetRepository extends JpaRepository<Budget, Long> {

//     List<Budget> findByCategory(String category);

    
// }


package com.spring.management.Repository;

import com.spring.management.Entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

    // Custom method to find Budgets by Category
    List<Budget> findByCategory(String category);

    // Custom JPQL method to find Budgets exceeding a certain amount
    List<Budget> findByAllocatedAmountGreaterThan(BigDecimal amount);
}
