package com.mercadolibre.movies.repository;

import com.mercadolibre.movies.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenreRepository extends JpaRepository<Genre, Long> {
}
