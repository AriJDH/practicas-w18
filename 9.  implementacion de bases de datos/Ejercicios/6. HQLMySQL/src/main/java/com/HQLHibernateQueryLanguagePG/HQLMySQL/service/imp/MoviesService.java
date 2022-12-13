package com.HQLHibernateQueryLanguagePG.HQLMySQL.service.imp;

import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO.MovieDTO;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.Movie;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.repository.IMoviesRepository;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.service.IMoviesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoviesService implements IMoviesService {
	
	// Dependencias -------------------------------- //
	final IMoviesRepository repository;
	
	@PersistenceContext EntityManager entityManager;
	
	final ObjectMapper mapper;
	
	public MoviesService(IMoviesRepository repository, ObjectMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	// CRUD -------------------------------- //
	@Override
	public List<MovieDTO> getAllMovies() {
		//List<Movie> movies = repository.findAll();       //Usando JPA
		List<Movie> movies = repository.findAllMovies();   //Usando HQL
		
		return movies.stream().map(movie -> mapper.convertValue(movie, MovieDTO.class))
						.collect(Collectors.toList());
	}
	
	// COMO SI HACERLO :)
	@Override
	public List<MovieDTO> getMoviesByTitleLike(String title) {
		List<Movie> movies = repository.findMoviesByTitleLike(title);
		
		return movies.stream().map(movie -> mapper.convertValue(movie, MovieDTO.class))
						.collect(Collectors.toList());
	}
	
	// COMO NO HACERLO 1! >:c
	@Override
	public List<MovieDTO> getMoviesByRatingGreaterThan(Double bound) {
		List<?> movies =
						entityManager.createQuery("select m from Movie m where m.rating > ?1").setParameter(1, bound)
										.getResultList();
		
		return movies.stream().map(movie -> mapper.convertValue(movie, MovieDTO.class))
						.collect(Collectors.toList());
	}
	
	
	// COMO NO HACERLO 2! >:c
	@Override
	public List<MovieDTO> getMoviesByAwardsGreaterThan(Integer awards) {
		TypedQuery<Movie> query = entityManager.createNamedQuery("MoviesByAwardsGreaterThan", Movie.class);
		query.setParameter("awards", awards);
		List<Movie> movies = query.getResultList();
		
		return movies.stream().map(movie -> mapper.convertValue(movie, MovieDTO.class))
						.collect(Collectors.toList());
	}
	
	// Solución individual -------------------------------- //
	// Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
	@Override
	public List<MovieDTO> findMoviesByActorsRatingGreaterThan(Double ratingNumber) {
		List<Movie> movieList = repository.findMoviesByActorsRatingGreaterThan(ratingNumber);
		return movieList.stream().map(movie -> mapper.convertValue(movie, MovieDTO.class))
						.collect(Collectors.toList());
	}
	
	// Listar todas las películas que pertenezcan al <género recibido por parámetro>
	@Override
	public List<MovieDTO> findMoviesByGenreId(Integer genreId) {
		List<Movie> movieList = repository.findMoviesByGenreId(genreId);
		return movieList.stream().map(movie -> mapper.convertValue(movie, MovieDTO.class))
						.collect(Collectors.toList());
		
	}
	
}
