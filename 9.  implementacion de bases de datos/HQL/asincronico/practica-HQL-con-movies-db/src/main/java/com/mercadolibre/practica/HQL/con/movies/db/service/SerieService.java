package com.mercadolibre.practica.HQL.con.movies.db.service;

import com.mercadolibre.practica.HQL.con.movies.db.model.Serie;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.SerieDTO;
import com.mercadolibre.practica.HQL.con.movies.db.repository.iSerieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService implements iSerieService{
    @Autowired
    iSerieRepository serieRepository;
    @Autowired
    ModelMapper mapper;


    @Override
    public List<SerieDTO> findSeriesByQuantityOfSeasons(Integer quantity) {
        List<Serie> series = serieRepository.findAllByQuantityOfSeasons(quantity);
        return series.stream().map(serie -> mapper.map(serie, SerieDTO.class)).collect(Collectors.toList());
    }
}
