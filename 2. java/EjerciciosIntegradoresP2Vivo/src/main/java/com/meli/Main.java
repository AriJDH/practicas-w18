package com.meli;

import com.meli.Dakar.Race;
import com.meli.SaveTheRopaSA.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EjercicioUno();
        EjercicioDos();
    }
    public static void EjercicioUno(){
        Closet closet = new Closet();
        List<Garmen> garmenList = new ArrayList<>();
        garmenList.add(new Garmen("marca 1","modelo 1"));
        garmenList.add(new Garmen("marca 2","modelo 2"));
        garmenList.add(new Garmen("marca 3","modelo 3"));
        garmenList.add(new Garmen("marca 4","modelo 4"));
        closet.saveGarmen(garmenList);
        closet.showGarmen();
        System.out.println(closet.getGarmen(Integer.valueOf(1)));
    }
    public static void EjercicioDos(){
        Race race = new Race(100,100,"ColombiaDakar",5);
        race.registerAuto(1200,3,10,"1");
        race.registerAuto(200,15,120,"2");
        race.registerMotorcycle(1000,3,10,"3");
        race.registerMotorcycle(10000,50,1,"4");
        race.registerMotorcycle(467,18,2,"5");
        race.registerMotorcycle(3004,12,2,"6");
        System.out.println("Campeon: "+ race.getChampion());
        race.helpAuto("2");
    }
}