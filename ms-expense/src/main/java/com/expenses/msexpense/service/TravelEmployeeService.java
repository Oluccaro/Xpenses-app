package com.expenses.msexpense.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenses.msexpense.dto.ExpenseDTO;
import com.expenses.msexpense.dto.TravelEmployeeDTO;
import com.expenses.msexpense.model.Employee;
import com.expenses.msexpense.model.Expense;
import com.expenses.msexpense.model.Travel;
import com.expenses.msexpense.model.TravelEmployee;
import com.expenses.msexpense.model.keys.TravelEmployeeKey;
import com.expenses.msexpense.repository.EmployeeRepository;
import com.expenses.msexpense.repository.ExpenseRepository;
import com.expenses.msexpense.repository.TravelEmployeeRepository;
import com.expenses.msexpense.repository.TravelRepository;

@Service
public class TravelEmployeeService {

  @Autowired
  private TravelRepository travelRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired 
  private TravelEmployeeRepository travelEmployeeRepo;

  @Autowired
  private ExpenseRepository expenseRepository;

  @Autowired
  private ModelMapper mapper;

  public TravelEmployeeDTO addEmployeeToTravel(Long travelId, Long employeeId){
    Travel travel = travelRepository.findById(travelId).orElse(null);
    if(travel != null){
      Employee employee = employeeRepository.findById(employeeId).orElse(null);
      if (employee != null){
        TravelEmployee travelEmployee = new TravelEmployee();
        TravelEmployeeKey travelEmployeeKey = new TravelEmployeeKey(travelId, employeeId);
        travelEmployee.setId(travelEmployeeKey);
        travelEmployee.setTravel(travel);
        travelEmployee.setEmployee(employee);
        travelEmployeeRepo.save(travelEmployee);
        return mapper.map(travelEmployee, TravelEmployeeDTO.class);
      }
    }
    return null;
  }

  public TravelEmployeeDTO getTravelExpenses(Long travelId, Long employeeId){
    TravelEmployeeKey travelEmployeeKey = new TravelEmployeeKey(travelId, employeeId);
    TravelEmployee travelEmployee = travelEmployeeRepo.findById(travelEmployeeKey).orElse(null);
    if(travelEmployee != null){
      return mapper.map(travelEmployee, TravelEmployeeDTO.class);
    }
    return null;
  }

  public TravelEmployeeDTO addExpense(Long travelId, Long employeeId, ExpenseDTO expenseDTO){
    Expense expense = mapper.map(expenseDTO, Expense.class);
    TravelEmployeeKey travelEmployeeKey = new TravelEmployeeKey(travelId, employeeId);
    TravelEmployee travelEmployee = travelEmployeeRepo.findById(travelEmployeeKey).orElse(null);
    expense.setTravelEmployee(travelEmployee);
    expenseRepository.save(expense);
    travelEmployee = travelEmployeeRepo.findById(travelEmployeeKey).orElse(null);
    if(travelEmployee != null){
      return mapper.map(travelEmployee, TravelEmployeeDTO.class);
    }
    return null;
  }


}
