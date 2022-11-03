package clase3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    
    
    
    public static void main(String[] args) {

        Garage g = new Garage(1 ,Arrays.asList(new Vehiculo("Ford", "Fiesta", 1000), 
                                                new Vehiculo("Ford", "Focus", 1200), 
                                                new Vehiculo("Ford", "Explorer", 2500),
                                                new Vehiculo("Fiat", "Uno", 500), 
                                               new Vehiculo("Fiat", "Cronos", 1000), 
                                               new Vehiculo("Fiat", "torino", 1250), 
                                               new Vehiculo("Chevrolet", "Aveo", 1250), 
                                               new Vehiculo("Chevrolet", "Spin", 2500), 
                                               new Vehiculo("Toyota", "Corolla", 1200), 
                                               new Vehiculo("Toyota", "Fotuner", 2000),
                                                new Vehiculo("Renault", "Logan", 950)));


        List<Vehiculo> l = g.getVehiculos();

       l.sort((Vehiculo v1, Vehiculo v2)->v1.getCosto()-v2.getCosto());

       System.out.println("");
        System.out.println("Lista ordenada segun costo: ");
        l.forEach((v)->System.out.println(v));


        l.sort((Vehiculo v1, Vehiculo v2)->v1.getMarca().compareTo(v2.getMarca()));

        System.out.println("");
        System.out.println("Lista ordenada segun marca: ");
        l.forEach((v)->System.out.println(v));

        int promedio = 0;
        int contador = 0;


        ArrayList<Vehiculo> l2 = new ArrayList<Vehiculo>();

        for (Vehiculo v : l){
            if (v.getCosto() < 1000 )
                l2.add(v);

            promedio += v.getCosto();
            contador++;
        }
        promedio = promedio / contador;

        System.out.println("");

        System.out.println("Lista de vehiculos con costo menor a 1000: ");
        l2.forEach((v)->System.out.println(v));

        System.out.println("");
        System.out.println("Promedio de costos: " + promedio);
      
    }


    
}
