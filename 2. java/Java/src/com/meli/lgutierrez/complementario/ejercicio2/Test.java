package com.meli.lgutierrez.complementario.ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Componente nave1 = new Nave("Apolo11", Arrays.asList(1, 1));
        Componente nave2 = new Nave("Apolo12", Arrays.asList(2, 2));
        Componente nave3 = new Nave("Apolo50", Arrays.asList(1, 5));
        Componente nave4 = new Nave("Apolo60", Arrays.asList(10, 5));

        List<Componente> naves = new ArrayList<>();
        naves.add(nave1);
        naves.add(nave2);

        Componente flotaNaves = new FlotaNaves(naves);

        Participante participante1 = new Participante("Laura", nave3);
        Participante participante2 = new Participante("Jhon", nave4);
        Participante participante3 = new Participante("Celeste", flotaNaves);

        List<Participante> participantes = new ArrayList<>();

        participantes.add(participante1);
        participantes.add(participante2);
        participantes.add(participante3);

        List<List<Integer>>coordenadasAsteroides = new ArrayList<>();

        List<Integer>coordenadas1 = Arrays.asList(6,15);
        List<Integer>coordenadas2 = Arrays.asList(1,10);
        List<Integer>coordenadas3 = Arrays.asList(6,45);
        List<Integer>coordenadas4 = Arrays.asList(8,2);
        List<Integer>coordenadas5 = Arrays.asList(25,15);

        coordenadasAsteroides.add(coordenadas1);
        coordenadasAsteroides.add(coordenadas2);
        coordenadasAsteroides.add(coordenadas3);
        coordenadasAsteroides.add(coordenadas4);
        coordenadasAsteroides.add(coordenadas5);

        Juego juego = new Juego(participantes, coordenadasAsteroides);

        juego.efectuarJuego();
        System.out.println("\n -------------------- El ganador del juego es: " + juego.definirGanador() +
                "Cuya puntuación fue de " + juego.definirGanador().getPuntuacion() +" -------------------");


    }
}
