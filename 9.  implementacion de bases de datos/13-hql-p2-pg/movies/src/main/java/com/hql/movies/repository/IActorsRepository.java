package com.hql.movies.repository;

import com.hql.movies.entity.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IActorsRepository extends JpaRepository<Actors, Long> {
    @Query("select a from Actors a where a.moviesByFavoriteMovieId is not null")
//    @Query("select a from Actors a where a.firstName like 'Harry'")
    List<Actors> findByFavoriteMovieIdIsNotNull();
}
