package com.uhu.multicapa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uhu.multicapa.dto.request.PersonDTO;
import com.uhu.multicapa.entity.Person;
import com.uhu.multicapa.repository.IPersonRepository;
import com.uhu.multicapa.repository.PersonRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImp implements IPersonService{

    private IPersonRepository personRepository = new PersonRepositoryImp();

    @Override
    public List<PersonDTO> getPeople() {
        ObjectMapper objectMapper = new ObjectMapper();
        personRepository = new PersonRepositoryImp();
        List<Person> personList = personRepository.findAll();
        List<PersonDTO> personDTOList = personList.stream()
                .map(person -> objectMapper.convertValue(person, PersonDTO.class))
                .collect(Collectors.toList());
        return personDTOList;
    }
}
