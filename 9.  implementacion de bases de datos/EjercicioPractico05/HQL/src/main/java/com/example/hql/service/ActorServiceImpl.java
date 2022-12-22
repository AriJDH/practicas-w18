package com.example.hql.service;

import com.example.hql.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements IActorService {

    private final ActorRepository actorRepository;

    @Override
    public List<String[]> getAllActorWithFavoriteMovie() {

        return actorRepository.getAllActorWithFavoriteMovie();
    }

    @Override
    public List<String[]> getAllActorWithRaitingGreaterThan(Double actorRating) {

        return actorRepository.getAllActorWithRaitingGreaterThan(actorRating);
    }

    @Override
    public List<String[]> getAllActorInMovieEqualsTo(String movieTitle) {

        return actorRepository.getAllActorInMovieEqualsTo(movieTitle);
    }

}
