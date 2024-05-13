package com.expenses.msexpense.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "t_expense")
public class Expense {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "description")
  private String description;

  @Column(name = "value")
  private Double value;

  @Column(name = "image")
  private String image;

  @ManyToOne
  @JoinColumn(name = "travel_id")
  @JoinColumn(name = "employee_id")
  private TravelEmployee travelEmployee;
}
