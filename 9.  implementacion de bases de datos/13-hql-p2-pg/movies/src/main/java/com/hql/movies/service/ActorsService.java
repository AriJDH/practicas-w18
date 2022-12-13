package com.hql.movies.service;

import com.hql.movies.entity.Actors;
import com.hql.movies.repository.IActorsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorsService implements IActorsService{

    private final IActorsRepository actorsRepository;

    public ActorsService(IActorsRepository actorsRepository) {
        this.actorsRepository = actorsRepository;
    }

    @Override
    public List<Actors> getActorsWithFavouriteMovie() {
        return actorsRepository.findByFavoriteMovieIdIsNotNull();
    }
}
