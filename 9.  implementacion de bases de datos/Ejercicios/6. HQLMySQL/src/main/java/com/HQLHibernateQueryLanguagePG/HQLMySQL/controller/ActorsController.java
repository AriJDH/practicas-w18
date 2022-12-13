package com.HQLHibernateQueryLanguagePG.HQLMySQL.controller;

import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO.ActorDTO;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO.ActorMovieResponceDTO;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.service.IActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorsController {
	
	final IActorService service;
	
	public ActorsController(IActorService service) {this.service = service;}
	
	@GetMapping("/actors")
	public List<ActorDTO> getActors() {
		return service.getAllActors();
	}
	
	@GetMapping("/actorbyname")
	public ActorDTO getActorByName(@RequestParam String name) {
		return service.getActorByName(name);
	}
	
	@GetMapping("/actormovie")
	public ActorMovieResponceDTO getActorWithfavoriteMovie(@RequestParam String name) {
		return service.getActorWithfavoriteMovie(name);
	}
	
	// Solución individual ---------------------------- //
	@GetMapping("/actormovienotnull")
	public ResponseEntity<?> findActorsByFavoriteMovieIsNotNull() {
		List<ActorDTO> actorDTOList = service.findActorsByFavoriteMovieIsNotNull();
		return ResponseEntity.ok().body(actorDTOList);
	}
	
	@GetMapping("/actorsratinggreaterthan/{ratingLimit}")
	public ResponseEntity<?> findActorsByRatingGreaterThan(@PathVariable Double ratingLimit) {
		List<ActorDTO> actorDTOList = service.findActorsByRatingGreaterThan(ratingLimit);
		return ResponseEntity.ok().body(actorDTOList);
	}
	
	@GetMapping("/actorsbymovie/{title}")
	public ResponseEntity<?> findActorsByMovie(@PathVariable String title) {
		List<ActorDTO> actorDTOList = service.findActorsByMovie(title);
		return ResponseEntity.ok().body(actorDTOList);
	}
}

