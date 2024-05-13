package com.expenses.msexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expenses.msexpense.model.TravelEmployee;
import com.expenses.msexpense.model.keys.TravelEmployeeKey;

public interface TravelEmployeeRepository extends JpaRepository<TravelEmployee, TravelEmployeeKey>{

}
