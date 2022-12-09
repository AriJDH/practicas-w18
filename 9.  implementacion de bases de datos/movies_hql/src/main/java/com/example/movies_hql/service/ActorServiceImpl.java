package com.example.movies_hql.service;

import com.example.movies_hql.dto.ActorDTO;
import com.example.movies_hql.entity.Actor;
import com.example.movies_hql.repository.IActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements IActorService {

    private final ModelMapper modelMapper = new ModelMapper();

    private final IActorRepository iActorRepository;

    public ActorServiceImpl(IActorRepository iActorRepository) {
        this.iActorRepository = iActorRepository;
    }

    public List<ActorDTO> buscarActoresConPeliculaFavorita() {

        List<Actor> actors = this.iActorRepository.buscarActoresConPeliculaFavorita();

       return actors.stream().map(actor -> modelMapper.map(actor, ActorDTO.class)).collect(Collectors.toList());
    }

    public List<ActorDTO> buscarActoresPorRating(BigDecimal rating) {

        List<Actor> actors = this.iActorRepository.buscarActoresPorRating(rating);

        return actors.stream().map(actor -> modelMapper.map(actor, ActorDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> buscarActoresPorPelicula(String nombrePelicula) {

        List<Actor> actors = this.iActorRepository.buscarActoresPorPelicula(nombrePelicula);

        return actors.stream().map(actor -> modelMapper.map(actor, ActorDTO.class)).collect(Collectors.toList());

    }
}
