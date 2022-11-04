package meli.bootcamp.clases;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premio;
    private String nombre;
    private int ctdVehiculosPermitidos;
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public Carrera(double distancia, double premio, String nombre, int ctdVehiculosPermitidos) {
        this.distancia = distancia;
        this.premio = premio;
        this.nombre = nombre;
        this.ctdVehiculosPermitidos = ctdVehiculosPermitidos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloGiro, String patente)
    {
        if (ctdVehiculosPermitidos > vehiculos.size())
        {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloGiro, patente));
            System.out.println("Vehiculo agregado");
        }
        else
        {
            System.out.println("ERROR, NO SE PERMITEN MAS VEHICULOS");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloGiro, String patente)
    {
        if (ctdVehiculosPermitidos > vehiculos.size())
        {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloGiro, patente));
            System.out.println("Vehiculo agregado");
        }
        else
        {
            System.out.println("ERROR, NO SE PERMITEN MAS VEHICULOS");
        }
    }

    public void eliminarVehiculo(Vehiculo v)
    {
        if (vehiculos.stream().anyMatch( x -> x.equals(v)))
        {
            vehiculos.remove(v);
            System.out.println("SE ELIMINO EL VEHICULO");
        }
        else
        {
            System.out.println("NO SE ENCONTRO EL VEHICULO");
        }
    }
    
    public void eliminarVehiculoConPatente(String patente)
    {
        int ubicacion = buscarVehiculo(patente);
        if (ubicacion != -1)
        {
            vehiculos.remove(ubicacion);
            System.out.println("VEHICULO ELIMINADO");
        }
        else
        {
            System.out.println("NO SE ENCONTRO EL VEHICULO");
        }
    }
    
    

    public void mostrarGanador()
    {
        System.out.println(buscarGanador());
    }

    private int buscarVehiculo(String patente)
    {
        int ubicacion = -1;
        for (int i = 0; i < vehiculos.size(); i++) {
            if (patente.equals(vehiculos.get(i).getPatente()))
            {
                ubicacion = i;
                return ubicacion;
            }
        }
        return ubicacion;
    }

    private Vehiculo buscarGanador()
    {
        double mayor = 0;
        int ubicacion = -1;
        for (int i = 0; i < vehiculos.size(); i++)
        {
            Vehiculo v = vehiculos.get(i);
            double formula = v.getVelocidad() * 0.5 * v.getAceleracion() / (v.getAnguloGiro()*(v.getPeso()*100));
            if (formula > mayor)
            {
                mayor = formula;
                ubicacion = i;
            }
        }
        return vehiculos.get(ubicacion);
    }
}
