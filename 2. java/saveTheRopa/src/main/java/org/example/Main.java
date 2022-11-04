package org.example;

import org.example.domain.GuardaRopa;
import org.example.domain.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static GuardaRopa guardaRopa= new GuardaRopa();
    public static void main(String[] args) {

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(new Prenda("marquita", "modelito"));
        prendas.add(new Prenda("marquita2", "modelito2"));
        int codigo = guardaRopa.guardarPrendas(prendas);
        System.out.println("Luego de guardar las prendas:");
        guardaRopa.mostrarPrendas();
        System.out.println("Luego de retirarlas:");
        List<Prenda> prendasdDevueltas= guardaRopa.devolverPrendas(codigo);
        System.out.println("Prendas devueltas:");
        prendasdDevueltas.forEach(p-> System.out.println(p.toString()));


    }
}