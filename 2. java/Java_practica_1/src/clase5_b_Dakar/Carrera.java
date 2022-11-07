package clase5_b_Dakar;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private Set<Vehiculo> listaVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculos = new HashSet<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();

    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro , String patente){
        if (existeCupo()) {
            Vehiculo auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.add(auto);
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro , String patente){
        if (existeCupo()) {
            Vehiculo moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.add(moto);
        }
    }
    public boolean existeCupo(){
        return (this.cantidadDeVehiculosPermitidos > this.listaVehiculos.size());
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        Optional<Vehiculo> veh = listaVehiculos.stream().filter(x -> x.equals(vehiculo)).findFirst();
        if (veh.isPresent()){
            listaVehiculos.remove(veh.get());
        }
    }
    public void eliminarVehiculoConPatente(String unaPatente){
        Optional<Vehiculo> veh = listaVehiculos.stream().filter(x -> x.equals(unaPatente)).findFirst();
        if (veh.isPresent()){
            listaVehiculos.remove(veh.get());
        }
    }

    public void ganadorCarrera(){
        Vehiculo ganador = listaVehiculos
                .stream()
                .max(Comparator.comparing(x-> x.getVelocidad() * x.getAceleracion() * 1/2 / (x.getAnguloDeGiro()*(x.getPeso()-x.getRuedas()*100))))
                .orElseThrow(()-> new RuntimeException("No existen vehículos en la carrera"));
        System.out.println("El vehículo ganador es " + ganador);
    }

    public void socorrerAuto(String patente){
        Vehiculo auto = listaVehiculos.stream().filter(x->x.equals(patente)).findFirst().orElseThrow(()-> new RuntimeException("No existe el auto para socorrer"));
        socorristaAuto.socorrer((Auto)auto);
    }
    public void socorrerMoto(String patente){
        Vehiculo moto = listaVehiculos.stream().filter(x->x.equals(patente)).findFirst().orElseThrow(()-> new RuntimeException("No existe la moto para socorrer"));
        socorristaMoto.socorrer((Moto)moto);
    }

}
