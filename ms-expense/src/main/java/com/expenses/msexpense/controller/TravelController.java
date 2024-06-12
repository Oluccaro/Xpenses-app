package com.expenses.msexpense.controller;

import java.util.List;

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

import com.expenses.msexpense.dto.TravelDTO;
import com.expenses.msexpense.dto.TravelWithEmployeeDTO;
import com.expenses.msexpense.service.TravelService;


@RestController
@RequestMapping("/travel")
@CrossOrigin
public class TravelController {

  @Autowired
  private TravelService travelService;

  @PostMapping
  public ResponseEntity<TravelDTO> createTravel(@RequestBody TravelDTO travelDTO){
    return new ResponseEntity<TravelDTO>(travelService.createTravel(travelDTO), HttpStatusCode.valueOf(201));
  }

  @GetMapping
  public ResponseEntity<List<TravelWithEmployeeDTO>> getAllTravels(){
    return new ResponseEntity<List<TravelWithEmployeeDTO>>(travelService.getAllTravels(), HttpStatusCode.valueOf(200));
  }

  @GetMapping("/{travelId}")
  public ResponseEntity<TravelDTO> getTravelById(@PathVariable Long travelId) {
      return new ResponseEntity<TravelDTO>(travelService.getTravelById(travelId), HttpStatusCode.valueOf(200));
  }
  
}
