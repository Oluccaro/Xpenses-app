package com.expenses.msexpense.dto;

import java.util.Date;
import java.util.List;

import com.expenses.msexpense.enums.TravelStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TravelWithEmployeeDTO {
  private Long id;
  private Date startDate;
  private Date endDate;
  private String description;
  private TravelStatus status;
  private List<EmployeeDTO> employees;
}
