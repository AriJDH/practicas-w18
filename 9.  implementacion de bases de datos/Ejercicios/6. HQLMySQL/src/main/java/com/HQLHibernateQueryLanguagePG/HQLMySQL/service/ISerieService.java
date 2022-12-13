package com.HQLHibernateQueryLanguagePG.HQLMySQL.service;

import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO.EpisodeDTO;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO.SerieDTO;

import java.util.List;

public interface ISerieService {
	
	List<SerieDTO> findSeriesGreaterThanSeasonsNumber(Integer seasonsNumber);
	
	List<EpisodeDTO> findEpisodesByActorId(Integer actorId);
}
