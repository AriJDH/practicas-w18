package com.HQLHibernateQueryLanguagePG.HQLMySQL.repository;

import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.Episode;
import com.HQLHibernateQueryLanguagePG.HQLMySQL.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Integer> {
	
	// Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
	@Query("FROM Serie S WHERE S.seasons.size > :seasonsNumber")
	List<Serie> findSeriesGreaterThanSeasonsNumber(@Param("seasonsNumber") Integer seasonsNumber);
	
	// Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
	@Query("SELECT A.linkedEpisodes FROM Actor A WHERE A.id = :actorId ")
	List<Episode> findEpisodesByActorId(@Param("actorId") Integer actorId);
}
