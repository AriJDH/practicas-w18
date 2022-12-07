package com.example.configurandoJPA.service;

import com.example.configurandoJPA.dto.MiniSerieDTOReq;
import com.example.configurandoJPA.dto.MiniSerieDTORes;
import com.example.configurandoJPA.model.MiniSerie;

import java.util.List;

public interface IMiniSerieService {
    List<MiniSerie> findAll();
     MiniSerie findById(Long id);
    MiniSerie create(MiniSerie miniSerie);
}
