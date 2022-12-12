package com.mercadolibre.practica.HQL.con.movies.db.service;

import com.mercadolibre.practica.HQL.con.movies.db.model.Episode;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.EpisodeDTO;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.MovieDTO;
import com.mercadolibre.practica.HQL.con.movies.db.repository.iEpisodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeService implements iEpisodeService {
    @Autowired
    iEpisodeRepository episodeRepository;
    @Autowired
    ModelMapper mapper;


    @Override
    public List<EpisodeDTO> findEpisodesWithActor(String actorName) {
        List<Episode> episodes = episodeRepository.findEpisodesByActor(actorName);

        return episodes.stream().map(e -> mapper.map(e, EpisodeDTO.class)).collect(Collectors.toList());
    }
}
