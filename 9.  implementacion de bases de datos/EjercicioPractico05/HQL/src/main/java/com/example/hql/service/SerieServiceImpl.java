package com.example.hql.service;

import com.example.hql.repository.SerieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SerieServiceImpl implements ISerieService{

    private final SerieRepository serieRepository;


    @Override
    public List<String[]> getAllSeriesWithSeasonGreaterThan(Integer numberOfSeasons) {

        return serieRepository.getAllSeriesWithSeasonGreaterThan(numberOfSeasons);
    }

}
