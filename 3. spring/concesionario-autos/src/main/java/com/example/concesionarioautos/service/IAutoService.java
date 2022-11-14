package com.example.concesionarioautos.service;

import com.example.concesionarioautos.dto.request.AutoRequestDTO;
import com.example.concesionarioautos.dto.response.AutoResponseDTO;
import com.example.concesionarioautos.dto.response.AutoSoloResponseDTO;

import java.util.List;

public interface IAutoService {

    public AutoResponseDTO add(AutoRequestDTO auto);
    public List<AutoSoloResponseDTO> listAll();
    public AutoResponseDTO findById(Long id);
    public List<AutoResponseDTO> findByYear(int since, int to);
    public List<AutoResponseDTO> findeByPrice(Double since, Double to);
}
