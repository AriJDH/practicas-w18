package com.example.moviehql.repository;

import com.example.moviehql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryMovie extends JpaRepository<Movie,Integer> {

    @Query("from Movie")
    List<Movie> getAllMovies();

    @Query("from Movie m where m.title like %:titleLike%")
    List<Movie> findAllMoviesByTitleLike(@Param("titleLike") String titleLike);
}
