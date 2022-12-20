package com.example.consultashql.service;

import com.example.consultashql.dto.Response.GenreDtoResp;
import com.example.consultashql.entity.Genre;

import java.util.List;
import java.util.Optional;

public interface IGenreService {

    GenreDtoResp getGenreById(Integer id);
}
