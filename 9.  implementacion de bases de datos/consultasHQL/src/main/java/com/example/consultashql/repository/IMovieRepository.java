package com.example.consultashql.repository;

import com.example.consultashql.entity.Genre;
import com.example.consultashql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    //Listar todas las películas que pertenezcan al <género recibido por parámetro>
    List<Movie>findMoviesByGenre(Genre genre);
}
