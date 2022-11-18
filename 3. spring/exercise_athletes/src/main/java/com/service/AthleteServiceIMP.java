package com.service;

import com.dto.response.SportDTOResponse;
import com.entity.Person;
import com.entity.Sport;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.repository.IPersonRepository;
import com.repository.ISportRepository;
import com.repository.PersonRepositoryIMP;
import com.repository.SportRepositoryIMP;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AthleteServiceIMP implements {
  private final IPersonRepository personRepository;
  private final ISportRepository sportRepository;
  private final ObjectMapper objectMapper;

  public AthleteServiceIMP(
    PersonRepositoryIMP personRepository,
    SportRepositoryIMP sportRepository,
    ObjectMapper objectMapper
  ) {
    this.personRepository = personRepository;
    this.sportRepository = sportRepository;
    this.objectMapper = objectMapper;
    this.objectMapper.configure(
        DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,
        false
      );
  }

  // @Override
  // public List<Person> getPeople() {
  //   return this.personRepository.getPeople();
  // }

  // @Override
  public List<SportDTOResponse> getSports() {
    List<SportDTOResponse> sports = new ArrayList<>();
    sportRepository
      .getSports()
      .forEach(
        s -> sports.add(new SportDTOResponse(s.getName(), s.getLevel()))
      );
    return sports;
  }
  // @Override
  // public Sport getSport(String name) {
  //   // TODO Auto-generated method stub
  //   return null;
  // }
  // @Override
  // public Sport getSport(String name) {
  //   Sport sport = this.sportRepository.getSport(name);
  //   return sport;
  // }
}
