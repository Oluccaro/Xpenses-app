package com.expenses.msexpense.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenses.msexpense.dto.EmployeeDTO;
import com.expenses.msexpense.model.Employee;
import com.expenses.msexpense.repository.EmployeeRepository;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private ModelMapper mapper;

  public EmployeeDTO createEmployee(EmployeeDTO employeeDTO){
    Employee employee = mapper.map(employeeDTO, Employee.class);
    employeeRepository.save(employee);
    return mapper.map(employee, EmployeeDTO.class);
  }

  public EmployeeDTO getEmployeeById(Long id){
    Employee employee = employeeRepository.findById(id).orElse(null);
    if(employee != null){
      return mapper.map(employee, EmployeeDTO.class);
    }
    return null;
  }
}
