import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {
    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(int premioEnDolares) {
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

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(cantidadDeVehiculosPermitidos <= vehiculos.size()) return;
        Vehiculo v = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        vehiculos.add(v);
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(cantidadDeVehiculosPermitidos <= vehiculos.size()) return;
        Vehiculo v = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        vehiculos.add(v);
    }

    public void eliminarVehiculo(Vehiculo v) {
        vehiculos.remove(v);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        this.vehiculos = vehiculos.stream()
                .filter(v -> !v.getPatente().equals(unaPatente))
                .collect(Collectors.toList());
    }

    public Vehiculo ganador() {
        return vehiculos.stream().max(Comparator.comparingDouble(Vehiculo::calcularValor)).get();
    }

    public void socorrerAuto(String unaPatente) {
        Vehiculo v = getVehiculoByPatente(unaPatente);
        Auto auto = new Auto(v.getVelocidad(), v.getAceleracion(), v.getAnguloDeGiro(), v.getPatente());
        socorristaAuto.socorrer(auto);
    }

    public void socorristaMoto(String unaPatente) {
        Vehiculo v = getVehiculoByPatente(unaPatente);
        Moto moto = new Moto(v.getVelocidad(), v.getAceleracion(), v.getAnguloDeGiro(), v.getPatente());
        socorristaMoto.socorrer(moto);
    }

    private Vehiculo getVehiculoByPatente(String unaPatente) {
        List<Vehiculo> vehiculo = vehiculos.stream()
                .filter(v -> v.getPatente().equals(unaPatente))
                .collect(Collectors.toList());
        return vehiculo.get(0);
    }
}
