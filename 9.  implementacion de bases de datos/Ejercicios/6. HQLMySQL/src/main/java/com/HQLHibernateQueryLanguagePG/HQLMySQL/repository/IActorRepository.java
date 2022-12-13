package com.HQLHibernateQueryLanguagePG.HQLMySQL.repository;

import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.Actor;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {
	
	// ---------------------------- Live Coding ---------------------------- //
	// Buscar todos los actores
	@Query("FROM Actor")
	List<Actor> findAllActors();
	
	// Buscar los actores por nombre
	@Query("From Actor A WHERE A.firstName LIKE :name")
	Actor findByFirstName(@Param("name") String name);
	
	// Buscar la película de cada actor (?
	@Query("FROM Movie M WHERE M.id = :id")
	Movie findMovieOfActor(@Param("id") Integer id);
	
	// ---------------------------- Solución individual ---------------------------- //
	// Listar todos los actores que tengan declarada una película favorita.
	@Query("FROM Actor A WHERE A.favoriteMovieId is not null")
	List<Actor> findActorsByFavoriteMovieIsNotNull();
	
	// Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
	@Query("FROM Actor A WHERE A.rating > :ratingLimit")
	List<Actor> findActorsByRatingGreaterThan(@Param("ratingLimit") Double ratingLimit);
	
	// Listar todos los actores que trabajan en la <película recibida por parámetro>
	@Query("SELECT M.actors FROM Movie M WHERE M.title LIKE :title")
	List<Actor> findActorsByMovie(@Param("title") String title);
	
}
