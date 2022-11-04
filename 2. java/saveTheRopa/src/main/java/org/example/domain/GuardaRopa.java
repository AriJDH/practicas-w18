package org.example.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> mapPrendas = new HashMap<>();
    private int contadorDePrendas = 0;

    public int guardarPrendas(List<Prenda> prendas){
        mapPrendas.put(contadorDePrendas, prendas);
        contadorDePrendas++;
        return contadorDePrendas-1;
    }

    public void mostrarPrendas(){
        mapPrendas.forEach((k,v)->{
            System.out.println("Prendas del guarda ropa:");
            System.out.println("\t" + "Codigo del guardarropas: "+ k + ". "+ v.toString());
        });
    }

    public List<Prenda> devolverPrendas(int codigo){
        return mapPrendas.get(codigo);
    }
}
