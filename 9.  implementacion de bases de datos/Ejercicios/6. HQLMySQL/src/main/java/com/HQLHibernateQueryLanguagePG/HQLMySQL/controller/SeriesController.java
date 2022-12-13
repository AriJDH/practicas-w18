package com.HQLHibernateQueryLanguagePG.HQLMySQL.controller;

import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO.EpisodeDTO;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO.SerieDTO;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.Episode;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.service.ISerieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeriesController {
	
	final ISerieService serieService;
	
	public SeriesController(ISerieService serieService) {this.serieService = serieService;}
	
	@GetMapping("/seriesGreaterThanSeasonsNumber/{seasonsNumber}")
	public ResponseEntity<?> findSeriesGreaterThanSeasonsNumber(@PathVariable Integer seasonsNumber) {
		List<SerieDTO> serieDTOList = serieService.findSeriesGreaterThanSeasonsNumber(seasonsNumber);
		return ResponseEntity.ok().body(serieDTOList);
	}
	@GetMapping("/findEpisodesByActorId/{actorId}")
	public ResponseEntity<?> findEpisodesByActorId(@PathVariable Integer actorId){
		List<EpisodeDTO> episodeList = serieService.findEpisodesByActorId(actorId);
		return ResponseEntity.ok().body(episodeList);
	}
}
