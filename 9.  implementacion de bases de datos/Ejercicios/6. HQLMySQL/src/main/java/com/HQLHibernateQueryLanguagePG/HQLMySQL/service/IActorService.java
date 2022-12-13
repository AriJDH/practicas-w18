package com.HQLHibernateQueryLanguagePG.HQLMySQL.service;

import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO.ActorDTO;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO.ActorMovieResponceDTO;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO.MovieDTO;

import java.util.List;

public interface IActorService {
	
	List<ActorDTO> getAllActors();
	
	ActorDTO getActorByName(String name);
	
	MovieDTO getMovieOfActor(Integer id);
	
	ActorMovieResponceDTO getActorWithfavoriteMovie(String name);
	
	List<ActorDTO> findActorsByFavoriteMovieIsNotNull();
	
	List<ActorDTO> findActorsByRatingGreaterThan(Double rating);
	
	List<ActorDTO> findActorsByMovie(String title);
	
}
