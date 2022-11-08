package practica_dakar.clases;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private Double distancia;

    private Double premioDolares;

    private String nombre;

    private Integer cantidadVehiculosPermitidos;

    private List<Vehiculo> vehiculos;

    private SocorristaAuto socorristaAuto;

    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioDolares, String nombre, Integer cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {

        if (hayCupoDisponible()) {
            System.out.println("No hay cupo disponible");
            return;
        }

        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);

        boolean contieneVehiculo = this.vehiculos.contains(auto);

        if (contieneVehiculo) {
            System.out.println("El vehiculo ya esta inscrito");
            return;
        }

        this.vehiculos.add(auto);

        System.out.println("Se registro correctamente");
    }

    public void darDeAltaMoto(Double velocidad,Double aceleracion,Double anguloDeGiro, String patente) {

        if (hayCupoDisponible()) {
            System.out.println("No hay cupo disponible");
            return;
        }

        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);

        boolean contieneVehiculo = this.vehiculos.contains(moto);

        if (contieneVehiculo) {
            System.out.println("El vehiculo ya esta inscrito");
            return;
        }

        this.vehiculos.add(moto);

        System.out.println("Se registro correctamente");
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {

        boolean eliminacionVehiculo = this.vehiculos.removeIf(x -> x.getPatente().equals(vehiculo.getPatente()));

        if (eliminacionVehiculo) {
            System.out.println("Se elimino exitosamente");
        } else {
            System.out.println("No existe el vehiculo registrado");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente) {

        boolean eliminacionVehiculo = this.vehiculos.removeIf(x -> x.getPatente().equals(unaPatente));

        if (eliminacionVehiculo) {
            System.out.println("Se elimino exitosamente");
        } else {
            System.out.println("No existe el vehiculo registrado");
        }
    }

    private boolean hayCupoDisponible() {
        return cantidadVehiculosPermitidos <= vehiculos.size();
    }

    public void socorrerAuto(String patente) {

        Auto autoASocorrer = null;

        for (Vehiculo vehiculo : vehiculos) {
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

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioDolares() {
        return premioDolares;
    }

    public void setPremioDolares(Double premioDolares) {
        this.premioDolares = premioDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(Integer cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
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

    public void socorrerMoto(String patente) {
        Moto motoASocorrer = null;
        for (Vehiculo vehiculo : vehiculos) {
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
