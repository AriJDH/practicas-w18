import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera() {

    }

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<Vehiculo>();
    }

    public double getDistancia() {
        return this.distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return this.premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return this.cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return this.listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public String toString() {
        return "Datos de la carrera: " + "\n" +
                "Distancia: " + this.distancia + "\n" +
                "Premio en dolares: " + this.premioEnDolares + "\n" +
                "Nombre: " + this.nombre + "\n" +
                "Cantidad de vehiculos permitidos: " + this.cantidadDeVehiculosPermitidos + "\n" +
                "Lista de vehiculos: " + this.listaDeVehiculos;
    }

    public boolean hayCupoDisponible() {
        return this.cantidadDeVehiculosPermitidos > this.listaDeVehiculos.size();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(!hayCupoDisponible()) {
            System.out.println("No hay cupo disponible para dar de alta un auto");
            return;
        }

        //Se crea un nuevo auto
        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);

        //Se valida que el auto no haya sido agregado previamente
        for(Vehiculo vehiculo : listaDeVehiculos) {
            if(vehiculo.getPatente().equals(auto.getPatente())){
                System.out.println("El auto ya se encuentra inscripto");
                return;
            }
        }

        boolean contains = listaDeVehiculos.contains(auto);
        if (contains) {
            System.out.println("El Auto ya se encuentra inscripto");
            return;
        }

        boolean agregadoCorrectamente = listaDeVehiculos.add(auto);
        if (!agregadoCorrectamente) {
            System.out.println("El Auto ya se encuentra inscripto");
            return;
        }

        System.out.println("Auto agregado automaticamente");

    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {

        if(!hayCupoDisponible()) {
            System.out.println("No hay cupo disponible para dar de alta un auto");
            return;
        }

        //Se crea una nueva moto
        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);

        //Se valida que la moto no haya sido agregado previamente
        for(Vehiculo vehiculo : listaDeVehiculos) {
            if(vehiculo.getPatente().equals(moto.getPatente())){
                System.out.println("El auto ya se encuentra inscripto");
                return;
            }
        }

        listaDeVehiculos.add(moto);
        System.out.println("Moto agregada automaticamente");

    }

    public void eliminarVehiculo(String patente) {

        Vehiculo vehiculosAEliminar = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                vehiculosAEliminar = vehiculo;
            }
        }

        if (vehiculosAEliminar != null) {
            eliminarVehiculo(vehiculosAEliminar);
        } else {
            System.out.println("El vehículo solicitado para eliminar no se encuentra inscripto.");
        }
    }

    public void eliminarVehiculo(Vehiculo unVehiculo) {
        if (listaDeVehiculos.remove(unVehiculo)) {
            System.out.println("Se eliminó correctamente al vehículo: " + unVehiculo);
        } else {
            System.out.println("El vehículo: " + unVehiculo + " no se encuentra inscripto.");
        }
    }

    public void socorrerAuto(String patente) {
        Auto autoASocorrer = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente) && vehiculo instanceof Auto) {
                autoASocorrer = (Auto) vehiculo;
            }
        }

        if (autoASocorrer != null) {
            socorristaAuto.socorrer(autoASocorrer);
        } else {
            System.out.println("No existe auto con la patente especificada para ser socorrido.");
        }
    }

    public void socorrerMoto(String patente) {
        Moto motoASocorrer = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente) && vehiculo instanceof Moto) {
                motoASocorrer = (Moto) vehiculo;
            }
        }

        if (motoASocorrer != null) {
            socorristaMoto.socorrer(motoASocorrer);
        } else {
            System.out.println("No existe moto con la patente especificada para ser socorrido.");
        }
    }




}
