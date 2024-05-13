package com.expenses.msexpense.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenses.msexpense.dto.TravelDTO;
import com.expenses.msexpense.dto.TravelWithEmployeeDTO;
import com.expenses.msexpense.model.Travel;
import com.expenses.msexpense.repository.TravelRepository;

@Service
public class TravelService {

  @Autowired
  private TravelRepository travelRepository;

  @Autowired
  private ModelMapper mapper;

  public TravelDTO createTravel(TravelDTO travelDTO){
    Travel travel = mapper.map(travelDTO, Travel.class);
    travelRepository.save(travel);
    return mapper.map(travel, TravelDTO.class);
  }

  public List<TravelWithEmployeeDTO> getAllTravels(){
    List<Travel> travels = travelRepository.findAll();
    List<TravelWithEmployeeDTO> travelWithEmployeeDTO = travels.stream()
                                        .map((travel)-> mapper.map(travel, TravelWithEmployeeDTO.class))
                                        .collect(Collectors.toList());
    return travelWithEmployeeDTO;
  }

  public TravelDTO getTravelById(Long id){
    Travel travel = travelRepository.findById(id).orElse(null);
    if (travel != null){
      return mapper.map(travel, TravelDTO.class);
    }
    return null;
  }
}
