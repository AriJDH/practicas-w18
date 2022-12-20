package com.example.consultashql.service.Impl;

import com.example.consultashql.dto.Response.GenreDtoResp;
import com.example.consultashql.entity.Genre;
import com.example.consultashql.repository.IGenreRepository;
import com.example.consultashql.service.IGenreService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements IGenreService {

    private IGenreRepository genreRepository;

    public GenreServiceImpl(IGenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public GenreDtoResp getGenreById(Integer id) {
        ModelMapper mapper = new ModelMapper();
        Genre genre = genreRepository.findById(id).get();
        return mapper.map(genre, GenreDtoResp.class);
    }
}
