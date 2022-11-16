package com.meli.lgutierrez.complementario.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Juego {

    private List<Participante> participantes;
    private List<List<Integer>> coordenadasAsteroide;
    private List<Componente> ganadoresPorRonda;

    public Juego(List<Participante> participantes, List<List<Integer>> coordenadasAsteroide) {
        this.participantes = participantes;
        this.coordenadasAsteroide = coordenadasAsteroide;
        this.ganadoresPorRonda = new ArrayList<>();
    }

    public void efectuarJuego(){
        double resultado = 10000;
        Componente componente = null;

        for (int i = 0; i < coordenadasAsteroide.size(); i++) {
            System.out.println("\n--------------- Ronda # " + (i+1) + " ---------------");
            for (Participante participante : participantes) {
                if (participante.getComponente().cercaniaAsteroide(coordenadasAsteroide.get(i)) < resultado){
                componente = participante.getComponente();
                resultado = participante.getComponente().cercaniaAsteroide(coordenadasAsteroide.get(i));
                }
                System.out.println("El participante " + participante.getNombre() + " con su nave o flota de naves, obtuvo una cercanía de " +
                        participante.getComponente().cercaniaAsteroide(coordenadasAsteroide.get(i)));
            }
            componente.setPuntuacion(1);
            ganadoresPorRonda.add(componente);
            System.out.println("\n----------- Ganador ronda # " + (i+1) + " -----------");
            System.out.println(componente.toString());
        }
    }

    public Componente definirGanador(){
        int resultado = 0;
        Componente ganador = null;
        for (Componente componente: ganadoresPorRonda) {

            if (componente.getPuntuacion() > resultado) {
                resultado = componente.getPuntuacion();
                ganador = componente;
            }
        }
        return ganador;
    }
}
