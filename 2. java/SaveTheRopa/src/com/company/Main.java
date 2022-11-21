package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	GuardaRopa guardaRopa = new GuardaRopa();
	Prenda prenda1 = new Prenda("The north face","Thermoball  Eco 2.0");
	Prenda prenda2 = new Prenda("Adidas","Tenis Run 70s Lifestyle");
	List<Prenda> listaPrendas = new ArrayList<Prenda>();
	listaPrendas.add(prenda1);
	listaPrendas.add(prenda2);

    Integer claveGuardaRopa = guardaRopa.guardarPrendas(listaPrendas);
	System.out.println("Sus prendas quedaron guardadas en el guardaropa #" + claveGuardaRopa);

	guardaRopa.mostrarPrendas();



    }
}
