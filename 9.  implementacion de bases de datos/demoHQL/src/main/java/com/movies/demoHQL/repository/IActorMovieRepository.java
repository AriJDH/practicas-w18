package com.movies.demoHQL.repository;

import com.movies.demoHQL.model.ActorMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActorMovieRepository extends JpaRepository<ActorMovie, Integer> {



}
