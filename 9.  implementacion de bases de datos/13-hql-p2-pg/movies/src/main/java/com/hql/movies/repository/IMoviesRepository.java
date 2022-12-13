package com.hql.movies.repository;

import com.hql.movies.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMoviesRepository extends JpaRepository<Movies, Long> {
}
