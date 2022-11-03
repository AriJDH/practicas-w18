package clase4_a_EjerciciosIntegrador.Ej1;

import java.util.List;

public class Garage {
    private long id;
    private List<Vehiculo> listaVehiculo;

    public Garage() {
    }

    public Garage(long id, List<Vehiculo> listaVehiculo) {
        this.id = id;
        this.listaVehiculo = listaVehiculo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(List<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }
}
