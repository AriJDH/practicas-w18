import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto = new SocorristaAuto();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Carrera() {
        this.vehiculos = new ArrayList<>();
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaAuto(Integer velocidad, Integer aceleracion, Integer AnguloDeGiro, String patente){
        if(cantidadDeVehiculosPermitidos > vehiculos.size()){
            Auto auto = new Auto(velocidad, aceleracion, AnguloDeGiro, patente);
            vehiculos.add(auto);
            System.out.println("Se ha agregado exitosamente el auto");
        }else{
            System.out.println("Lamentamos informarle que se llegó al límite de la cantidad de vehículos permitidos");
        }
    }
    public void darDeAltaMoto(Integer velocidad, Integer aceleracion, Integer AnguloDeGiro, String patente){

        if(cantidadDeVehiculosPermitidos > vehiculos.size()){
            Moto moto1 = new Moto(velocidad, aceleracion, AnguloDeGiro, patente);
            vehiculos.add(moto1);
            System.out.println("Se ha agregado exitosamente la moto");
        }else{
            System.out.println("Lamentamos informarle que se llegó al límite de la cantidad de vehículos permitidos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculos.stream().filter(v -> v.getPatente() == vehiculo.getPatente()));
    }
    public void eliminarVehiculoConPatente(String unaPatente){
        vehiculos.remove(vehiculos.stream().filter(v -> v.getPatente().equals(unaPatente)));
    }

    public String ganador(){
        Vehiculo vehiculoGanador = null;
        Double puntaje = 0.0;

        for(Vehiculo vehiculo : vehiculos){
            Double actual = (vehiculo.getVelocidad() * (vehiculo.getAceleración()/2)) / (vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas() * 100));
            if(actual>puntaje){
                vehiculoGanador = vehiculo;
            }
        }

        return vehiculoGanador.toString();
    }

    public void socorrerAuto(String patente){
        Vehiculo auto= vehiculos.stream().filter(v -> v.getPatente().equals(patente)).collect(Collectors.toList()).get(0);
        socorristaAuto.socorrer((Auto)auto);
    }
    public void socorrerMoto(String patente){
        Vehiculo moto= vehiculos.stream().filter(v -> v.getPatente().equals(patente)).collect(Collectors.toList()).get(0);
        socorristaMoto.socorrer((Moto)moto);
    }



}
