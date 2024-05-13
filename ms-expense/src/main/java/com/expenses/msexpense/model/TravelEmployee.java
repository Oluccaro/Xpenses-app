package com.expenses.msexpense.model;


import java.util.Set;

import com.expenses.msexpense.model.keys.TravelEmployeeKey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "t_travel_employee")
public class TravelEmployee {

  @EmbeddedId
  private TravelEmployeeKey id;

  @ManyToOne
  @MapsId("employeeId")
  @JoinColumn(name = "employee_id")
  private Employee employee;

  @ManyToOne
  @MapsId("travelId")
  @JoinColumn(name = "travel_id")
  private Travel travel;

  @OneToMany(mappedBy = "travelEmployee")
  private Set<Expense> expenses;
}
