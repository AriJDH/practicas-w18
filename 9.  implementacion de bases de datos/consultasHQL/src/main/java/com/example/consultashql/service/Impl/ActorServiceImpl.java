package com.example.consultashql.service.Impl;

import com.example.consultashql.dto.Request.MovieDtoReq;
import com.example.consultashql.dto.Response.ActorDtoResp;
import com.example.consultashql.entity.Actor;
import com.example.consultashql.entity.Movie;
import com.example.consultashql.repository.IActorRepository;
import com.example.consultashql.service.IActorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements IActorService {
    private IActorRepository actorRepository;
    private ModelMapper mapper = new ModelMapper();

    public ActorServiceImpl(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
    @Override
    public List<ActorDtoResp> obtenerActoresConPeliculaFavorita1(){
        List<Actor> actorEntity = actorRepository.findActorsByFavoriteMovieNotNull();
        return mapeadorEntityaDto(actorEntity);
    }
    @Override
    public List<ActorDtoResp> obtenerActoresConPeliculaFavorita2(){
        List<Actor> actorEntity = actorRepository.obtenerActoresConPeliculaFavortita();
        return mapeadorEntityaDto(actorEntity);
    }
    @Override
    public List<ActorDtoResp> obtenerActoresPorPeliculaFavortita(Integer id) {
        List<Actor> actorEntity = actorRepository.findActorsByFavoriteMovie_Id(id);
        return mapeadorEntityaDto(actorEntity);
    }

    @Override
    public List<ActorDtoResp> obtenerActoresPorRatingMayorA(Integer id) {
        List<Actor> actorEntity = actorRepository.findActorsByRatingGreaterThan(id);
        return mapeadorEntityaDto(actorEntity);
    }

    private List<ActorDtoResp> mapeadorEntityaDto(List<Actor> enity){
        return enity.stream().map(a -> mapper.map(a, ActorDtoResp.class)).collect(Collectors.toList());
    }
}
