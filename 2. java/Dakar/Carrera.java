package Dakar;

import java.util.List;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(auto);
        } else {
            System.out.println("No hay cupos disponibles");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {

        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(moto);
        } else {
            System.out.println("No hay cupos disponibles");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                listaDeVehiculos.remove(vehiculo);
            }
        }
    }

    public Vehiculo ganador() {
        Vehiculo ganador = null;
        double mayorPuntaje = 0;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            double puntaje = vehiculo.getVelocidad() * vehiculo.getAceleracion()*(0.5) / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if (puntaje > mayorPuntaje) {
                mayorPuntaje = puntaje;
                ganador = vehiculo;
            }
        }
        return ganador;
    }

    public void socorrerAuto(String patente) {
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                socorristaAuto.socorrer((Auto) vehiculo);
            }
        }
    }

    public void socorrerMoto(String patente) {
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                socorristaMoto.socorrer((Moto) vehiculo);
            }
        }
    }

    
}

