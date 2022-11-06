package com.company;

import com.company.Clase.GuardaRopa;
import com.company.Clase.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda1 = new Prenda("Nike","remera");
        Prenda prenda2 = new Prenda("Adidas", "pantalon");

        List <Prenda> listaPrenda = new ArrayList<>();
        listaPrenda.add(prenda1);
        listaPrenda.add(prenda2);

        int nroPrenda = guardaRopa.guardarPrendas(listaPrenda);

        guardaRopa.mostrarPrendas();

        List<Prenda> devolucion = guardaRopa.devolverPrendas(100);

        devolucion.forEach(Prenda::imprimir);

    }
}
