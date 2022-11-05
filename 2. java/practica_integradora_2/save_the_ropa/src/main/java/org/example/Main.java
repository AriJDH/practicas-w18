package org.example;

import org.example.models.GuardaRopa;
import org.example.models.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuardaRopa g = new GuardaRopa();
        Prenda p1 = new Prenda("Levis", "501");
        Prenda p2 = new Prenda("Wrangler", "SlimFit");
        List<Prenda> l = new ArrayList<>();
        l.add(p1);
        l.add(p2);

        List<Prenda> l2 = new ArrayList<>();
        l2.add(p1);
        l2.add(p2);

        System.out.println(g.guardarPrendas(l));
        System.out.println(g.guardarPrendas(l2));
        g.mostrarPrendas();

        System.out.println("--------------------------");
        System.out.println("\n*** DEVOLVER PRENDA ***");
        System.out.println(g.devolverPrendas(1));
    }
}