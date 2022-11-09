package ejercicio2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrera {

    private String nombre;
    private int distancia;
    private int premioEnDolares;
    private int cantidadVehiculosPermitidos;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;
    private List<Vehiculo> vehiculos;


    public Carrera(int cantidadVehiculosPermitidos) {

        this.socorristaMoto = new SocorristaMoto();
        this.socorristaAuto = new SocorristaAuto();
        this.vehiculos = new ArrayList<>();
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public void darAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente){

        if (this.vehiculos.size() < cantidadVehiculosPermitidos) {

            this.vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
            System.out.println("Alta del Vehiculo efectuada !");
        } else {
            System.out.println("Se alcanzo la cantidad maxima de Participantes !");
        }
    }

    public void darAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente){

        if (this.vehiculos.size() < cantidadVehiculosPermitidos) {

            this.vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
            System.out.println("Alta del Vehiculo efectuada !");
        }   else {
            System.out.println("Se alcanzo la cantidad maxima de Participantes !");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){

        if (this.vehiculos.remove(vehiculo)){
            System.out.println("Vehiculo eliminado !");
        } else {
            System.out.println("No se pudo eliminar el Vehiculo !");
        }
    }

    public void eliminarVehiculoConPatente(String patente){

        if (this.vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente))){
            System.out.println("Vehiculo eliminado !");
        } else {
            System.out.println("No se pudo eliminar el Vehiculo !");
        }
    }

    public void definirGanador(){

        double aux = 0;
        Vehiculo ganador = null;

        for (Vehiculo elemento : this.vehiculos){

            double aux2 = elemento.getVelocidad() * 0.5 * elemento.getAceleracion() /
                    ( elemento.getAnguloDeGiro() * ( elemento.getPeso() - elemento.getRuedas() * 100 ) );

            if (aux2 > aux){
                aux = aux2;
                ganador = elemento;
            }
        }

        System.out.println("Vehiculo Ganador: " + ganador.getPatente());
    }

    public void socorrerAuto(String patente){

        Optional<Vehiculo> auto = vehiculos.stream().filter(x-> x.getPatente().equals(patente)).findFirst();
        if (auto.isPresent()){
            socorristaAuto.socorrer((Auto) auto.get());
        } else {
            System.out.println("No se encontro el auto para Socorrerlo !");
        }
    }

    public void socorrerMoto(String patente){

        Optional<Vehiculo> moto = vehiculos.stream().filter(x-> x.getPatente().equals(patente)).findFirst();
        if (moto.isPresent()){
            socorristaMoto.socorrer((Moto) moto.get());
        } else {
            System.out.println("No se encontro la moto para Socorrerla !");
        }
    }

}
