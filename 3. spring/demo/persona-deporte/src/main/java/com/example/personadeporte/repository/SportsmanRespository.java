package com.example.personadeporte.repository;

import com.example.personadeporte.entity.Sportsman;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public abstract class SportsmanRespository {

    private static final List<Sportsman> sportsmans = new ArrayList<>();

    public static void addSportsman(Sportsman sportsman){
        sportsmans.add(sportsman);
    }

    public static List<Sportsman> getSportsmans(){
        return sportsmans;
    }

    public static void removeSportsman(Sportsman sportsman){
        sportsmans.remove(sportsman);
    }

}
