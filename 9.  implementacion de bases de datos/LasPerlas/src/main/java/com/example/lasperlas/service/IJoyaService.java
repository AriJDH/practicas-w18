package com.example.lasperlas.service;

import com.example.lasperlas.dto.GenericResponseDto;
import com.example.lasperlas.dto.JoyasDto;

import java.util.List;

public interface IJoyaService {

    JoyasDto findById(Long id);
    List<JoyasDto> findAll();
    GenericResponseDto create(JoyasDto joya);
    GenericResponseDto delete(Long id);
    GenericResponseDto update(Long id, JoyasDto joya);
}
