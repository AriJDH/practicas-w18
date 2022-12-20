package com.example.consultashql.service.Impl;

import com.example.consultashql.dto.Request.MovieDtoReq;
import com.example.consultashql.dto.Response.ActorDtoResp;
import com.example.consultashql.entity.Actor;
import com.example.consultashql.entity.ActorMovie;
import com.example.consultashql.entity.Movie;
import com.example.consultashql.repository.IActorMovieRepository;
import com.example.consultashql.service.IActorMovieService;
import com.example.consultashql.service.IGenreService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Formatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorMovieServiceImpl implements IActorMovieService {

    private IActorMovieRepository actorMovieRepository;
    private ModelMapper mapper = new ModelMapper();
    private IGenreService genreService;

    public ActorMovieServiceImpl(IActorMovieRepository actorMovieRepository, IGenreService genreService) {
        this.actorMovieRepository = actorMovieRepository;
        this.genreService = genreService;
    }
    @Override
    public List<ActorDtoResp> obtenerActoresPorPelicula(MovieDtoReq movie) {
        Movie movieEntity = new Movie();
        movieEntity.setId(movie.getId());
        movieEntity.setCrearedAt(movie.getCrearedAt());
        movieEntity.setUpdatedAt(movie.getUpdatedAt());
        movieEntity.setTitle(movie.getTitle());
        movieEntity.setRating(movie.getRating());
        movieEntity.setAwards(movie.getAwards());
        movieEntity.setReleaseDate(movie.getReleaseDate());
        movieEntity.setLength(movie.getLength());
        movieEntity.setGenre(null);

        List<Actor> actorsEntity = actorMovieRepository.listarActoresPorPelicula(movieEntity);
        List<ActorDtoResp> actorsDto=
                            actorsEntity.stream()
                                    .map(a -> mapper.map(a, ActorDtoResp.class))
                                    .collect(Collectors.toList());
        return actorsDto;
    }

    @Override
    public List<MovieDtoReq> obtenerPeliculasPorRatingActor(Integer rating) {
        List<Movie> moviesEntity = actorMovieRepository.listarPeliculasPorActorConRatingMayorA(rating);
        List<MovieDtoReq> moviesDto =
                    moviesEntity.stream()
                        .map(m -> mapper.map(m, MovieDtoReq.class))
                        .collect(Collectors.toList());
        return moviesDto;
    }
}
