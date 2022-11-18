package com.multiacapa.starswars.service;

import com.multiacapa.starswars.dto.PersonajeDTOres;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonajesService {
    List<PersonajeDTOres> getAll();

    List<PersonajeDTOres> getByName(String name);
}
