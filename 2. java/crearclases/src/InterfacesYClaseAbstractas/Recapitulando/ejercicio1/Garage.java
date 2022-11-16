package InterfacesYClaseAbstractas.Recapitulando.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private int id;
    List<Vehiculo> vehiculos = new ArrayList<>();

    public Garage(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }
}
