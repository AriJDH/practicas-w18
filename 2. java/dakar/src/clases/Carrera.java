package clases;

import java.util.List;

public class Carrera implements SocorristaMoto, SocorristaAuto {
    private int distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    List<Vehiculo> listaVehiculos;

    public Carrera() {
    }

    public Carrera(int distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> listaVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculos = listaVehiculos;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public void darDeAltaAuto(int velocidad, double aceleracion, int anguloDeGiro, String patente) {
        //Ambos métodos agregan un vehículo siempre y cuando haya cupo.
        if ( listaVehiculos.size() < cantidadDeVehiculosPermitidos) {
//          Auto auto = new Auto(((Auto) listaVehiculos).getVelocidad(), ((Auto) listaVehiculos).getAceleracion(), anguloDeGiro, patente);
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.add(auto);
        }else{
            System.out.println("Lo sentimos ya no se permite agregar un vehiculo ya que ya no hay cupo");
        }
    }

    public void darDeAltaMoto(int velocidad, double aceleracion, int anguloDeGiro, String patente){
        //Ambos métodos agregan un vehículo siempre y cuando haya cupo.
        if (cantidadDeVehiculosPermitidos < listaVehiculos.size()) {
//                    Moto moto = new Moto(((Moto) listaVehiculos).getVelocidad(), ((Moto) listaVehiculos).getAceleracion(), anguloDeGiro, patente);
            Moto moto = new Moto(velocidad,aceleracion, anguloDeGiro, patente);
            listaVehiculos.add(moto);
        }else
            System.out.println("Lo sentimos ya no se permite agregar un vehiculo ya que ya no hay cupo");
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if (listaVehiculos.remove(vehiculo)) {
            System.out.println("Se eliminó el vehículo: " + vehiculo);
        } else {
            System.out.println("El vehículo: " + vehiculo + " no se encontro.");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        for(Vehiculo vehiculo : listaVehiculos){
            if(vehiculo.getPatente().equals(unaPatente)){
                listaVehiculos.remove(vehiculo);
                System.out.println("Se elimino el vehiculo con la patente: "+unaPatente);
            }
        }

    }

    public void defineGanador(){
        double resultado;
        //velocidad * 1/2 aceleracion /(anguloDeGiro *(peso-cantidadDeRuedas*100)));
        for(Vehiculo vehiculos: listaVehiculos){
            resultado = (vehiculos.getVelocidad()*(vehiculos.getAceleracion()/2))/(vehiculos.getAnguloDeGiro()*(vehiculos.getPeso()-vehiculos.getRuedas()*100));
        }    }

    public void imprimirListaVehiculos()
    {
        for (Vehiculo vehiculos:listaVehiculos) {
            System.out.println("************************");
            System.out.println("Patente: " +vehiculos.getPatente());
            System.out.println("Acelracion: " +vehiculos.getAceleracion());
            System.out.println("Peso: " +vehiculos.getPeso());
            System.out.println("Ruedas: " +vehiculos.getRuedas());
            System.out.println("Velocidad: "+vehiculos.getVelocidad());
            System.out.println("Angulo de giro: "+vehiculos.getAnguloDeGiro());
        }
    }

    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo Auto");
    }

    @Override
    public void socorrer(Moto moto) {
        System.out.println("Socorriendo Moto");
    }

    @Override
    public void socorrerAuto(String patente) {
        for(Vehiculo vehiculo : listaVehiculos){
            if(vehiculo.getPatente().equals(patente) ){
                System.out.println("Socorriendo al auto con patente: "+patente);
            }else{
                System.out.println("No se encontro al auto con patente: "+patente);
            }
        }
    }

    @Override
    public void socorrerMoto(String patente) {
        for(Vehiculo vehiculo : listaVehiculos){
            if(vehiculo.getPatente().equals(patente) && vehiculo instanceof  Moto){
                System.out.println("Socorriendo a la moto con patente: "+patente);
            }
        }
    }
}
