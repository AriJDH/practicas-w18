package com.company.Clase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class GuardaRopa {
    private int contador = 100;
    private Map<Integer, List<Prenda>> guardaR = new HashMap<>();

    public GuardaRopa() {
    }

    public GuardaRopa(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        int id = getContador();

        guardaR.put(id, listaDePrenda);
        System.out.println(getContador());
        setContador(id + 100);
        //System.out.println(getContador());
        return getContador();
    }

    public void mostrarPrendas() {
        //guardaR.forEach((k, v) -> System.out.println("Clave: " + k + ", Valores: " + v));
        guardaR.forEach((k, v) -> System.out.println("Clave: " + k));
    }

    public List<Prenda> devolverPrendas(Integer key) {

        return guardaR.get(key);
    }
}
