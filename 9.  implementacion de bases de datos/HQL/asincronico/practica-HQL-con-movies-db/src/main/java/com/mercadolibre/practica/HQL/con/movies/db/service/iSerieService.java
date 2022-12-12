package com.mercadolibre.practica.HQL.con.movies.db.service;

import com.mercadolibre.practica.HQL.con.movies.db.model.dto.SerieDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface iSerieService {
    List<SerieDTO> findSeriesByQuantityOfSeasons(Integer quantity);
}
