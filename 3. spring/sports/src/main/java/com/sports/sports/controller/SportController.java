package com.sports.sports.controller;

import com.sports.sports.entities.Sport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportController {
    @GetMapping("/findSports")
    public List<Sport> findSports(){
        return Sport.sports;
    }
}
