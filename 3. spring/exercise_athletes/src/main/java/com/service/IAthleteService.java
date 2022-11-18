package com.service;

import com.dto.response.SportDTOResponse;
import com.entity.*;
import java.util.List;
import java.util.Optional;

public interface IAthleteService {
  public List<SportDTOResponse> getSports();

  public List<Person> getPeople();

  public Sport getSport(String name);
}
