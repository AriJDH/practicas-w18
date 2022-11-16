package com.meli.lgutierrez.clase5.ejercicioPractico1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private int contador;

    public GuardaRopa() {
        prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.prendas.put(++contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> prenda: prendas.entrySet()) {
            System.out.println("La clave de la lista de prendas es: " + prenda.getKey());
            System.out.println("Y contiene los siguientes elementos " + prenda.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return prendas.get(numero);
    }
}
