package com.expenses.msexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expenses.msexpense.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}
