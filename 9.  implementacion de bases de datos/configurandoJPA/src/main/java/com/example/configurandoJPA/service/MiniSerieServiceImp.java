package com.example.configurandoJPA.service;

import com.example.configurandoJPA.dto.MiniSerieDTORes;
import com.example.configurandoJPA.model.MiniSerie;
import com.example.configurandoJPA.respository.IMiniSerieRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiniSerieServiceImp implements IMiniSerieService{
    private final IMiniSerieRepository miniSerieRepository;

    public MiniSerieServiceImp(IMiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
    }
    @Override
    public List<MiniSerie> findAll(){

        return  miniSerieRepository.findAll();
    }
    @Override
    public MiniSerie findById(Long id){
       return miniSerieRepository.findById(id).orElseThrow(()->new RuntimeException("NO SE ENCUENTRA"));
    }

    @Override
    public MiniSerie create(MiniSerie miniSerie) {
        return miniSerieRepository.save(miniSerie);
    }

}
