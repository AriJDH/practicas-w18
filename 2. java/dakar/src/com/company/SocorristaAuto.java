package com.company;

public class SocorristaAuto extends Vehiculo{
    public SocorristaAuto() {
    }

    public void socorrer(Auto auto){
        System.out.println("Socorriendo auto");
        //Mostrar datos del auto
        System.out.println(auto.toString());
    }
}
