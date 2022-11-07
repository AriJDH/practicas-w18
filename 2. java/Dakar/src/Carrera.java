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

    public Carrera(Double distancia,
                   Double premioEnDolares,
                   String nombre,
                   Integer cantidadDeVehiculosPermitidos,
                   List<Vehiculo> vehiculos,
                   SocorristaAuto socorristaAuto,
                   SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    // Métodos
    public void darDeAltaAuto(Double velocidad,
                              Double aceleracion,
                              Double anguloDeGiro,
                              String patente) {
        // Agrega un vehículo a la carrera, siempre y cuando haya cupo
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(auto);
        } else System.out.println("No se puede agregar el vehículo, el cupo está lleno.");
    }

    public void darDeAltaMoto(Double velocidad,
                              Double aceleracion,
                              Double anguloDeGiro,
                              String patente) {
        // Agrega una moto a la carrera, siempre y cuando haya cupo
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(moto);
            System.out.println("Vehiculo agregado");
        } else System.out.println("No se puede agregar el vehículo, el cupo está lleno.");
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        // Elimina un vehiculo de la carrera (auto/moto)
        vehiculos.remove(vehiculo);
        System.out.println("Vehiculo borrado");
    }

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
        //Vehiculo auxVehiculo2 = null;
        // Buscamos el ganador recorriendo la lista de vehiculos
        for (Vehiculo vehiculo : vehiculos) {
            resultado =
                    vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() /
                            (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if (resultado > auxResultado) {
                auxResultado = resultado;
                auxVehiculo = vehiculo;
            }
//            else if(resultado == auxResultado){
//                auxVehiculo2 = vehiculo;
//            }
        }
        System.out.println("El ganador es " + auxVehiculo + "con el siguiente resultado: " + auxResultado);
//        if(auxVehiculo2 != null && resultado == auxResultado ){
//            System.out.println("Y el vehiculo " + auxVehiculo2 + " resultó también ganador con el mismo resultado");
//        }
    }

    public void socorrerAuto(String patente) {
        // -------------- Opción Stream para encontrar auto -------------- //
        // Auto auto = (Auto) vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente));

        // -------------- Opción For para encontrar auto -------------- //
        Auto auto = new Auto();
        for (Vehiculo vehiculo : vehiculos) {
            // Verificamos que el vehículo sea un auto
            if (vehiculo instanceof Auto) {
                // Buscamos el auto que coincida con la patente
                if (vehiculo.getPatente().compareTo(patente) == 0) {
                    auto = (Auto) vehiculo;
                }
            }
        }

        // Socorremos al auto
        socorristaAuto.socorrer(auto);
    }

    public void socorrerMoto(String patente) {
        // -------------- Opción Stream para encontrar moto  -------------- //
        // Moto moto = (Moto) vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente));

        // -------------- Opción For para encontrar moto  -------------- //
        Moto moto = new Moto();
        for (Vehiculo vehiculo : vehiculos) {
            // Verificamos que el vehículo sea una moto
            if (vehiculo instanceof Moto) {
                if (vehiculo.getPatente().compareTo(patente) == 0) {
                    moto = (Moto) vehiculo;
                }
            }
        }

        // Socorremos al auto
        socorristaMoto.socorrer(moto);
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
                ", socorristaMoto=" + socorristaMoto +
                '}';
    }
}
