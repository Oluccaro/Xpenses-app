package com.expenses.msexpense.model;

import java.sql.Date;
import java.util.Set;

import com.expenses.msexpense.enums.TravelStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "t_travel")
public class Travel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "start_date")
  private Date startDate;
  
  @Column(name = "end_date")
  private Date endDate;

  @Column(name = "description")
  private String description;

  @Column(name = "status")
  private TravelStatus status;

  @ManyToMany
  @JoinTable(
    name = "t_travel_employee",
    joinColumns = @JoinColumn(name = "travel_id"),
    inverseJoinColumns = @JoinColumn(name = "employee_id")
  )
  private Set<Employee> employees;

}
