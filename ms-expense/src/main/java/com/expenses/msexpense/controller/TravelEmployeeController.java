package com.expenses.msexpense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.msexpense.dto.ExpenseDTO;
import com.expenses.msexpense.dto.TravelEmployeeDTO;
import com.expenses.msexpense.service.TravelEmployeeService;

@RestController
@RequestMapping("/travel/{travelId}/employee/{employeeId}")
@CrossOrigin
public class TravelEmployeeController {

  @Autowired
  private TravelEmployeeService travelEmployeeService;

  @PostMapping
  public ResponseEntity<TravelEmployeeDTO> addEmployeeToTravel(@PathVariable Long travelId, @PathVariable Long employeeId){
    return new ResponseEntity<TravelEmployeeDTO>(travelEmployeeService.addEmployeeToTravel(travelId, employeeId),HttpStatusCode.valueOf(201));
  }

  @GetMapping
  public ResponseEntity<TravelEmployeeDTO> getTravelExpenses(@PathVariable Long travelId, @PathVariable Long employeeId){
    return new ResponseEntity<TravelEmployeeDTO>(travelEmployeeService.getTravelExpenses(travelId, employeeId), HttpStatusCode.valueOf(200));
  }

  @PostMapping("/expense")
  public ResponseEntity<TravelEmployeeDTO> addExpense(@PathVariable Long travelId, @PathVariable Long employeeId, @RequestBody ExpenseDTO expenseDTO){
    return new ResponseEntity<TravelEmployeeDTO>(travelEmployeeService.addExpense(travelId, employeeId, expenseDTO), HttpStatusCode.valueOf(201));
  }
}
