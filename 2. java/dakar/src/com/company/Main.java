package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Carrera carreraAutos = new Carrera();

        double velocidad = 0;
        double aceleracion = 0;
        int anguloDeGiro = 0;
        String patente ="ABC123CDD";

        //datos de carrera
        carreraAutos.setNombre("Carrera Autos");
        carreraAutos.setDistancia(100);
        carreraAutos.setPremioEnDolares(4000);
        carreraAutos.setCantidadDeVehiculosPermitidos(10);

        //ingreso de autos deberia ser por teclado

        if(carreraAutos.getListaVehiculos().size() <= carreraAutos.getCantidadDeVehiculosPermitidos()){
            carreraAutos.darDeAltaAuto(velocidad,aceleracion,anguloDeGiro,patente);
        }else{
            System.out.println("No hay mas cupos");
        }


    }
}
