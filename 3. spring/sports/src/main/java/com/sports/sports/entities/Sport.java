package com.sports.sports.entities;

import java.util.ArrayList;

public class Sport {
    private String name;
    private String level;

    public static ArrayList<Sport> sports;

    public Sport(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public static void saveSport(Sport s) {
        sports.add(s);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}



