package com.example.hql.controller;

import com.example.hql.service.ISerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
public class SerieController {

    private final ISerieService serieService;


    @GetMapping("/query6")
    public ResponseEntity<?> getQuery6(@RequestParam(name = "number_of_seasons") Integer numberOfSeasons){

        return new ResponseEntity<>(serieService.getAllSeriesWithSeasonGreaterThan(numberOfSeasons), HttpStatus.OK);
    }

}
