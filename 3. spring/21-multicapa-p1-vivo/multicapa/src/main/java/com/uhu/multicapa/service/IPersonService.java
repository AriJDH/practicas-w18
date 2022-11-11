package com.uhu.multicapa.service;

import com.uhu.multicapa.dto.request.PersonDTO;

import java.util.List;

public interface IPersonService {
    List<PersonDTO> getPeople();
}
