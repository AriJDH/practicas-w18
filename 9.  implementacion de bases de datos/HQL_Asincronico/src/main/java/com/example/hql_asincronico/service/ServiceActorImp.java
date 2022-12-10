package com.example.hql_asincronico.service;

import com.example.hql_asincronico.entity.Actor;
import com.example.hql_asincronico.repository.IRepositoryActor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceActorImp implements IServiceActor{
    private final IRepositoryActor iRepositoryActor;

    public ServiceActorImp(IRepositoryActor iRepositoryActor){
        this.iRepositoryActor = iRepositoryActor;
    }
    @Override
    public List<Actor> findByFavoriteMovieNotNull() {
        return iRepositoryActor.findByFavoriteMovieNotNull();
    }
}
