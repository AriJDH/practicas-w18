package com.demohql.mysql.repository;

import com.demohql.mysql.entities.entity.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieActorRepository extends JpaRepository<MovieActor, Integer> {
}
