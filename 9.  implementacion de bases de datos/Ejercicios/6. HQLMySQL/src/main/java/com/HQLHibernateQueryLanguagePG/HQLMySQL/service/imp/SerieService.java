package com.HQLHibernateQueryLanguagePG.HQLMySQL.service.imp;

import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO.EpisodeDTO;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO.SerieDTO;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.Episode;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.Serie;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.repository.ISerieRepository;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.service.ISerieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService implements ISerieService {
	
	// Dependencias -------------------------------- //
	final ISerieRepository serieRepository;
	
	final ObjectMapper mapper;
	
	public SerieService(ISerieRepository serieRepository, ObjectMapper mapper) {
		this.serieRepository = serieRepository;
		this.mapper = mapper;
	}
	
	// Solución individual -------------------------------- //
	// Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
	@Override
	public List<SerieDTO> findSeriesGreaterThanSeasonsNumber(Integer seasonsNumber) {
		List<Serie> serieList = serieRepository.findSeriesGreaterThanSeasonsNumber(seasonsNumber);
		return serieList.stream().map(serie -> mapper.convertValue(serie, SerieDTO.class))
						.collect(Collectors.toList());
	}
	
	// Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
	@Override
	public List<EpisodeDTO> findEpisodesByActorId(Integer actorId) {
		List<Episode> episodeList = serieRepository.findEpisodesByActorId(actorId);
		return episodeList.stream().map(episode -> mapper.convertValue(episode, EpisodeDTO.class))
						.collect(Collectors.toList());
	}
	
}
