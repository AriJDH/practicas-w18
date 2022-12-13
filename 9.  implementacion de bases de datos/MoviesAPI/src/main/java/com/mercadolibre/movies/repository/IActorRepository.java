package com.mercadolibre.movies.repository;

import com.mercadolibre.movies.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActorRepository extends JpaRepository<Actor, Long> {
}
