package com.expenses.msexpense.model.keys;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TravelEmployeeKey implements Serializable{
  @Column(name = "travel_id")
  Long travelId;

  @Column(name = "employee_id")
  Long employeeId;

  @Override
  public int hashCode(){
    return Objects.hash();
  }

  @Override
  public boolean equals(Object obj){
    TravelEmployeeKey travelEmployeeKey = (TravelEmployeeKey) obj;
    return travelEmployeeKey.getEmployeeId() == this.employeeId && travelEmployeeKey.travelId == this.travelId;
  }
}
