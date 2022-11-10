package com.example.personadeporte.repository;

import com.example.personadeporte.entity.Sport;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public abstract class SportRepository {
    private static final List<Sport> sports = new ArrayList<Sport>();

    public static void addSport(Sport sport) {
        sports.add(sport);
    }

    public static List<Sport> getSports() {
        return sports;
    }

}
