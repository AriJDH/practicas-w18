package com.jpa.joyeria.service;

import com.jpa.joyeria.dto.GenericResponseDTO;
import com.jpa.joyeria.model.Joya;

import java.util.List;

public interface IJoyaService {
    GenericResponseDTO save(Joya Joya);
    List<Joya> getAll();
    GenericResponseDTO update(Joya joya, int id);
    GenericResponseDTO delete(int id);
}
