package com.expenses.msexpense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.msexpense.dto.EmployeeDTO;
import com.expenses.msexpense.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @PostMapping
  public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
    return new ResponseEntity<EmployeeDTO>(employeeService.createEmployee(employeeDTO), HttpStatusCode.valueOf(201));
  }

  @GetMapping("/{id}")
  public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id){
    return new ResponseEntity<EmployeeDTO>(employeeService.getEmployeeById(id), HttpStatusCode.valueOf(200));
  }
}
