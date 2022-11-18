package com.example.covid.service;

import com.example.covid.dto.PersonDTORes;
import com.example.covid.entity.Person;

import java.util.List;

public interface IPersonService {
    List<PersonDTORes> findRiskPerson();
}
