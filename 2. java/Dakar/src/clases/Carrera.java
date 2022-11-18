package clases;

import java.util.*;
import java.util.stream.Collectors;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private Set<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorriendoMoto socorriendoMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, Set<Vehiculo> vehiculos, SocorristaAuto socorristaAuto, SocorriendoMoto socorriendoMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorriendoMoto = socorriendoMoto;
    }

    public Boolean hayCuposDisponibles(){
        return (cantidadDeVehiculosPermitidos>vehiculos.size());
    }


    public void darDeAltaAuto(Double velocidad,Double aceleracion, Double anguloDeGiro,String patente){
        Auto auto = new Auto(velocidad,aceleracion,anguloDeGiro,patente);
        if (hayCuposDisponibles()){
            if (vehiculos.contains(auto)){
                System.out.println("El auto con patente '"+auto.getPatente()+ "' ya se encuentra registrado");;
            } else {
                vehiculos.add(auto);
                System.out.println("El auto con patente '"+auto.getPatente()+"' se registró correctamente");
            }

        } else {
            System.out.println("No hay cupos disponibles para la carrera '"+this.nombre+"'");
        }
    }

    public void darDeAltaMoto(Double velocidad,Double aceleracion, Double anguloDeGiro,String patente){
        Moto moto = new Moto(velocidad,aceleracion,anguloDeGiro,patente);
        if (hayCuposDisponibles()){
            if (vehiculos.contains(moto)){
                System.out.println("La moto con patente '"+moto.getPatente()+ "' ya se encuentra registrada");;
            } else {
                vehiculos.add(moto);
                System.out.println("La moto con patente '"+moto.getPatente()+"' se registró correctamente");
            }

        } else {
            System.out.println("No hay cupos disponibles para la carrera '"+this.nombre+"'");
        }
    }

    public void eliminarAuto(Double velocidad,Double aceleracion, Double anguloDeGiro,String patente){
        Auto auto = new Auto(velocidad,aceleracion,anguloDeGiro,patente);
             if (vehiculos.contains(auto)){
                 vehiculos.remove(auto);
                 System.out.println("El auto con patente '"+auto.getPatente()+ "' fue eliminado de la carrera");;
            } else {
                System.out.println("El auto con patente '"+auto.getPatente()+"' no está inscripto");
            }
    }

    public void eliminarAuto(String patente){
        Vehiculo vehiculoEliminar = null;
        for (Vehiculo vehiculo: vehiculos) {
            if(vehiculo.getPatente().equals(patente)){
                vehiculoEliminar = vehiculo;
            }
        }
        if (vehiculoEliminar !=null){
            System.out.println("El auto con patente '"+patente+"' fue eliminado de la carrera");
            vehiculos.remove(vehiculoEliminar);

        } else {
            System.out.println("El auto con patente '"+patente+"' no está inscripto");
        }
    }

    public void eliminarMoto(String patente){
        Vehiculo vehiculoEliminar = null;
        for (Vehiculo vehiculo: vehiculos) {
            if(vehiculo.getPatente().equals(patente)){
                vehiculoEliminar = vehiculo;
            }
        }
        if (vehiculoEliminar !=null){
            System.out.println("La moto con patente '"+patente+"' fue eliminada de la carrera");
            vehiculos.remove(vehiculoEliminar);

        } else {
            System.out.println("La moto con patente '"+patente+"' no está inscripta");
        }
    }

    public void eliminarMoto(Double velocidad,Double aceleracion, Double anguloDeGiro,String patente){
        Moto moto = new Moto(velocidad,aceleracion,anguloDeGiro,patente);
        if (vehiculos.contains(moto)){
            vehiculos.remove(moto);
            System.out.println("La moto con patente '"+moto.getPatente()+ "' fue eliminada de la carrera");;
        } else {
            System.out.println("La moto con patente '"+moto.getPatente()+"' no está inscripta");
        }
    }

    public void determinarGanador(){
        List<Double> resultados= new ArrayList<>();
        Double formula=0.0;
        for (Vehiculo vehiculo:vehiculos) {
            formula = (vehiculo.getVelocidad()*0.5*vehiculo.getAceleracion())/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()*1));
            resultados.add(formula);
        }
        System.out.println("El ganador de la carrera "+this.nombre+" tuvo un resultado de: "+resultados.stream().max((x,y)-> x.compareTo(y)).orElseThrow(()->new RuntimeException("No hay resultados")));
    }

    public void socorrerAuto(String patente){
        Vehiculo vehiculoSocorrer= null;
        for(Vehiculo vehiculo: vehiculos){
            if(vehiculo.getPatente().equals(patente)){
                vehiculoSocorrer=vehiculo;
            }
        }
        if(vehiculoSocorrer!=null){
            System.out.println("El auto con patente '"+patente+"' está siendo socorrido");;
        } else{
            System.out.println("El auto con patente '"+patente+"' no está inscripto en la carrera");;
        }
    }

    public void socorrerMoto(String patente){
        Vehiculo vehiculoSocorrer= null;
        for(Vehiculo vehiculo: vehiculos){
            if(vehiculo.getPatente().equals(patente)){
                vehiculoSocorrer=vehiculo;
        }
        }
        if(vehiculoSocorrer!=null){
            System.out.println("La moto con patente '"+patente+"' está siendo socorrida");;
        } else{
            System.out.println("La moto con patente '"+patente+"' no está inscripta en la carrera");;
        }
    }




    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", vehiculos=" + vehiculos +
                ", socorristaAuto=" + socorristaAuto +
                ", socorriendoMoto=" + socorriendoMoto +
                '}';
    }


}
