package com.HQLHibernateQueryLanguagePG.HQLMySQL.controller;

import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO.MovieDTO;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.service.IMoviesService;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesController {
	
	final IMoviesService service;
	
	public MoviesController(IMoviesService service) {this.service = service;}
	
	@GetMapping("/movies")
	public List<MovieDTO> getMoviesByTLike(@Nullable @RequestParam String titleLike) {
		return titleLike == null ? service.getAllMovies() : service.getMoviesByTitleLike(titleLike);
	}
	
	@GetMapping("/moviesByRatingGreaterThan")
	public List<MovieDTO> getMoviesByRatingGreaterThan(@RequestParam Double lowerBound) {
		return service.getMoviesByRatingGreaterThan(lowerBound);
	}
	
	@GetMapping("/moviesByAwardsGreaterThan")
	public List<MovieDTO> getMoviesByAwardsGreaterThan(@RequestParam Integer awards) {
		return service.getMoviesByAwardsGreaterThan(awards);
	}
	
	// Solución individual ---------------------------- //
	@GetMapping("/moviesByActorsRatingGreaterThan/{ratingNumber}")
	public ResponseEntity<?> findMoviesByActorsRating(@PathVariable Double ratingNumber) {
		List<MovieDTO> movieDTOList = service.findMoviesByActorsRatingGreaterThan(ratingNumber);
		return ResponseEntity.ok().body(movieDTOList);
	}
	
	@GetMapping("/moviesByGenreId/{genreId}")
	public ResponseEntity<?> findMoviesByGenreId(@PathVariable Integer genreId){
		List<MovieDTO> movieDTOList = service.findMoviesByGenreId(genreId);
		return ResponseEntity.ok().body(movieDTOList);
	}
	
}
