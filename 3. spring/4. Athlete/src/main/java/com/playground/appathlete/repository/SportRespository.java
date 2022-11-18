package com.playground.appathlete.repository;

import com.playground.appathlete.entity.Sport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SportRespository {

    // Creo Deportes
    Sport sport1 = new Sport("basquet", Level.semiprofesional);
    Sport sport2 = new Sport("tenis", Level.amateur);
    Sport sport3 = new Sport("golf", Level.profesional);
    Sport sport4 = new Sport("soccer",Level.profesional);

}
