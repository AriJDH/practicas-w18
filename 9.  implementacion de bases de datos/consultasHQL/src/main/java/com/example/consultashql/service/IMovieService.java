package com.example.consultashql.service;

import com.example.consultashql.dto.Request.GenreDtoReq;
import com.example.consultashql.dto.Response.MovieDtoResp;
import com.example.consultashql.entity.Movie;

import java.util.List;

public interface IMovieService {
    public List<MovieDtoResp> getMoviesByGenre(GenreDtoReq genre);
}
