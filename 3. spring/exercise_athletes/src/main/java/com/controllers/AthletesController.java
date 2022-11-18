package com.controllers;

import com.dto.response.SportDTOResponse;
import com.service.AthleteServiceIMP;
import com.service.IAthleteService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sports")
public class AthletesController {
  private final AthleteServiceIMP athleteService;

  public AthletesController(AthleteServiceIMP athleteService) {
    this.athleteService = athleteService;
  }

  @GetMapping("/findSports")
  public ResponseEntity<List<SportDTOResponse>> getSports() {
    return new ResponseEntity<>(athleteService.getSports(), HttpStatus.OK);
  }
  // @GetMapping("/findSports/{sport}")
  // public ResponseEntity<SportDTOResponse> getDeport(@PathVariable String sport) {
  //   SportDTOResponse sportDTOResponse = athleteService.getSport(sport);
  //   return ResponseEntity.ok().body(sportDTOResponse);
  // }

  // @GetMapping("/findSportsPersons")
  // @ResponseBody
  // public AthletesDTORequest getSportsPeople() {
  //   // Person person = new Person("Alingel", "Torreszz", 32);
  //   // Sport sport = new Sport("Soccer", "Professional");

  //   // AthletesDTORequest athletesDTO = new AthletesDTORequest(person, sport);

  //   // // AthletesDTO athletesDTO = new AthletesDTO();

  //   // athletesDTO.setId(123123221231232L);
  //   // // athletesDTO.setFullname(person.getName() + " " + person.getLastName());
  //   // // athletesDTO.setSport(sport.getName());

  //   // return athletesDTO;
  // }
}
