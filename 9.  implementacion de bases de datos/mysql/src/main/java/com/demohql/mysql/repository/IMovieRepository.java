package com.demohql.mysql.repository;

import com.demohql.mysql.entities.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    @Query("From Movie M WHERE M.title like %:movieName%")
    Movie findMovieByName(@Param("movieName") String movieName);
}
