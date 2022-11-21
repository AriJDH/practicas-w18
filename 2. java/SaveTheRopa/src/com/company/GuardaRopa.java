package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {



    private  Integer contador = 0;
    private HashMap<Integer,List<Prenda>> guardaropa = new HashMap<>();






    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        contador += 1;
        guardaropa.put(contador,listaDePrenda);
        return contador;
    }


    public void mostrarPrendas(){

        for (Map.Entry<Integer,List<Prenda>> entry:guardaropa.entrySet()){
            System.out.println("Clave Guardaropa " + entry.getKey());
            System.out.println("Prendas");
            for (Prenda prenda: entry.getValue()){
                System.out.println(prenda);
            }
        }

    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> prendasDevolver = guardaropa.get(numero);
        return prendasDevolver;
    }

}
