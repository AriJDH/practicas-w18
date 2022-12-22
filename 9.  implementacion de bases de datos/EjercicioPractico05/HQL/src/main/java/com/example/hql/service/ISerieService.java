package com.example.hql.service;

import java.util.List;

public interface ISerieService {

    List<String[]> getAllSeriesWithSeasonGreaterThan(Integer numberOfSeasons);

}
