package com.expenses.msexpense.dto;

import java.util.Date;
import java.util.List;

import com.expenses.msexpense.enums.TravelStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "name", "startDate", "endDate", "status", "employees"})
public class TravelWithEmployeeDTO {
  private Long id;
  private Date startDate;
  private Date endDate;
  @JsonProperty("name")
  private String description;
  private TravelStatus status;
  private List<EmployeeDTO> employees;
}
