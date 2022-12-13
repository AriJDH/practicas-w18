package com.HQLHibernateQueryLanguagePG.HQLMySQL.service.imp;


import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.Actor;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO.ActorDTO;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO.ActorMovieResponceDTO;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO.MovieDTO;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.Movie;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.repository.IActorRepository;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.service.IActorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService {
	
	// Dependencias -------------------------------- //
	final
	IActorRepository repository;
	
	final
	ObjectMapper mapper;
	
	public ActorService(ObjectMapper mapper, IActorRepository repository) {
		this.mapper = mapper;
		this.repository = repository;
	}
	
	// CRUD -------------------------------- //
	@Override
	public List<ActorDTO> getAllActors() {
		List<Actor> actors = repository.findAllActors();
		
		return actors
						.stream()
						.map(actor -> mapper.convertValue(actor, ActorDTO.class))
						.collect(Collectors.toList());
	}
	
	@Override
	public ActorDTO getActorByName(String name) {
		Actor actor = repository.findByFirstName(name);
		
		return mapper.convertValue(actor, ActorDTO.class);
	}
	
	// Otros métodos -------------------------------- //
	@Override
	public MovieDTO getMovieOfActor(Integer id) {
		Movie movie = repository.findMovieOfActor(id);
		
		return mapper.convertValue(movie, MovieDTO.class);
	}
	
	
	public ActorMovieResponceDTO getActorWithfavoriteMovie(String name) {
		ActorMovieResponceDTO actorMovie = new ActorMovieResponceDTO();
		ActorDTO actor = getActorByName(name);
		MovieDTO movie = getMovieOfActor(actor.getFavoriteMovieId());
		actorMovie.setActor(actor);
		actorMovie.setFavoriteMovie(movie);
		return actorMovie;
	}
	
	// Solución individual -------------------------------- //
	// Listar todos los actores que tengan declarada una película favorita.
	@Override
	public List<ActorDTO> findActorsByFavoriteMovieIsNotNull() {
		List<Actor> actorList = repository.findActorsByFavoriteMovieIsNotNull();
		return actorList
						.stream()
						.map(actor -> mapper.convertValue(actor, ActorDTO.class))
						.collect(Collectors.toList());
	}
	
	// Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
	@Override
	public List<ActorDTO> findActorsByRatingGreaterThan(Double ratingLimit) {
		List<Actor> actorList = repository.findActorsByRatingGreaterThan(ratingLimit);
		return actorList
						.stream()
						.map(actor -> mapper.convertValue(actor, ActorDTO.class))
						.collect(Collectors.toList());
	}
	
	
	// Listar todos los actores que trabajan en la <película recibida por parámetro>
	@Override
	public List<ActorDTO> findActorsByMovie(String title) {
		List<Actor> actorList = repository.findActorsByMovie(title);
		return actorList
						.stream()
						.map(actor -> mapper.convertValue(actor, ActorDTO.class))
						.collect(Collectors.toList());
	}
	
	
}