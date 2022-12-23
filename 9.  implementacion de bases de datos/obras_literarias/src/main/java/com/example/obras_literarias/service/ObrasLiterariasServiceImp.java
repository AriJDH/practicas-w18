package com.example.obras_literarias.service;

import com.example.obras_literarias.dto.ObrasLiterariasDTO;
import com.example.obras_literarias.model.ObraLiteraria;
import com.example.obras_literarias.repository.ObraLiterariaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ObrasLiterariasServiceImp implements IObrasLiterariasService{
    final ObjectMapper mapper;
    final ObraLiterariaRepository obraLiterariaRepository;

    public ObrasLiterariasServiceImp(ObjectMapper mapper, ObraLiterariaRepository obraLiterariaRepository) {
        this.mapper = mapper;
        this.obraLiterariaRepository = obraLiterariaRepository;
    }


    @Override
    public void guardarObra(ObrasLiterariasDTO obrasLiterariasDTO) {
        ObraLiteraria obraLiteraria = mapper.convertValue(obrasLiterariasDTO, ObraLiteraria.class);
        obraLiterariaRepository.save(obraLiteraria);
    }
}
