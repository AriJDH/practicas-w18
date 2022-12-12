package com.mercadolibre.practica.HQL.con.movies.db.service;

import com.mercadolibre.practica.HQL.con.movies.db.model.dto.EpisodeDTO;
import com.mercadolibre.practica.HQL.con.movies.db.repository.iEpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface iEpisodeService {
    List<EpisodeDTO> findEpisodesWithActor(String actorName);
}
