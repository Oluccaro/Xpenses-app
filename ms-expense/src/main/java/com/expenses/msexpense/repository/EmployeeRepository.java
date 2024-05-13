package com.expenses.msexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expenses.msexpense.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
