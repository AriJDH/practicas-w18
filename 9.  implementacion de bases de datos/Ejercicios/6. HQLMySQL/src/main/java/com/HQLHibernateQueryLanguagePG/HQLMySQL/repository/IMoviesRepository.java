package com.HQLHibernateQueryLanguagePG.HQLMySQL.repository;

import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMoviesRepository extends JpaRepository<Movie, Integer> {
	
	// ---------------------------- Live Coding ---------------------------- //
	// Buscar las películas ordenadas por título
	@Query("FROM Movie m order by m.title")
	List<Movie> findAllMovies();
	
	// Buscar las películas por su título
	@Query("FROM Movie m WHERE m.title LIKE %:title%")
	List<Movie> findMoviesByTitleLike(@Param("title") String title);
	
	// ---------------------------- Solución individual ---------------------------- //
	// Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
	@Query("SELECT A.linkedMovies FROM Actor A WHERE A.rating > :ratingNumber")
	List<Movie> findMoviesByActorsRatingGreaterThan(@Param("ratingNumber") Double ratingNumber);
	
	// Listar todas las películas que pertenezcan al <género recibido por parámetro>
	@Query("FROM Movie M WHERE M.genreId = :genreId")
	List<Movie> findMoviesByGenreId(@Param("genreId") Integer genreId);
	
}
