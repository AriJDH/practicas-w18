package com.example.personadeporte.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sportsman {

    private String name;
    private String lastName;
    private int age;
    private List<Sport> sports = new ArrayList<Sport>();

    public Sportsman(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public void addSport(Sport sport) {
        sports.add(sport);
    }


}
