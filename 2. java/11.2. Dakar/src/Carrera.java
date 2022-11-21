import java.util.List;

public class Carrera {

    // Atributos
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    // Constructores
    public Carrera() {
    }

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    // Métodos

    // Agrega un auto a la carrera
    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        if (vehiculos.size() < cantidadDeVehiculosPermitidos){
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(auto);
            System.out.println("Se agrego un auto");
        } else System.out.println("No se puede agregar el vehiculo, El cupo esta lleno");
        //Ambos agregan un vehiculo siempre y cuando haya cupo
    }

    // Agrega una Moto a la carrera
    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        if (vehiculos.size() < cantidadDeVehiculosPermitidos){
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(moto);
            System.out.println("Se agrego una moto");
        } else System.out.println("No se puede agregar el vehiculo, El cupo esta lleno");
    }

    // Eliminar un vehiculo
    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);

    }

    // Eliminar una moto con patente
    public void eliminarVehiculoConPatente(String unaPatente) {
        // Elimina un vehiculo (Auto/Moto) por patente
        Vehiculo vehiculoEncontrado = null;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPatente().compareTo(unaPatente) == 0) {
                vehiculoEncontrado = vehiculo;
                System.out.println("Vehiculo borrado");
            } else System.out.println("No existe vehículo con la patente ingresada");
        } vehiculos.remove(vehiculoEncontrado);
    }

    public void definirGanadorDeCarrera() {
        Double resultado = 0.00; // Variable para guardar los resultados en cada iteracion
        Double auxResultado = 0.00; // Variable para guardar el resultado mayor
        Vehiculo auxVehiculo = null; // Variable que guarda el vehículo que va ganando
        Vehiculo auxVehiculo2 = null;
        // Buscamos el ganador recorriendo la lista de vehiculos
        for (Vehiculo vehiculo : vehiculos) {
            resultado =
                    vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() /
                            (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if (resultado > auxResultado) {
                auxResultado = resultado;
                auxVehiculo = vehiculo;
            } /*else if(resultado == auxResultado){
                auxVehiculo2 = vehiculo;
            }*/
        }
        /*System.out.println("El ganador es " + auxVehiculo + "con el siguiente resultado: " + auxResultado);
        if(auxVehiculo2 != null && resultado == auxResultado ){
            System.out.println("Y el vehiculo " + auxVehiculo2 + " resultó también ganador con el mismo resultado");
        }*/
    }

    public void socorrerAuto(String patente){
        // Opcion Stream
        // Auto auto = (Auto) this.vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente));

        // ForEach
        Auto auto = new Auto();
        for(Vehiculo vehiculo: vehiculos){
            // Verificamos que el vehículo sea un auto
            if (vehiculo instanceof Auto) {
                if (vehiculo.getPatente().compareTo(patente) == 0) {
                    auto = (Auto) vehiculo;
                }
            }
        }
        this.socorristaAuto.socorrer(auto);
    }

    public void socorrerMoto(String patente){
        Moto moto = new Moto();
        for(Vehiculo vehiculo: vehiculos){
            // Verificamos que el vehículo sea un auto
            if (vehiculo instanceof Moto) {
                if (vehiculo.getPatente().compareTo(patente) == 0) {
                    moto = (Moto) vehiculo;
                }
            }
        }
        this.socorristaMoto.socorrer(moto);
    }



}