package com.expenses.msexpense.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TravelEmployeeDTO {
  private TravelDTO travel;
  private EmployeeDTO employee;
  private List<ExpenseDTO> expenses;
}
