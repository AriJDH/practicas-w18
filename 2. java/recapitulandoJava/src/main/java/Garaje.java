import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private String ID;
    private List<Vehiculo> vehiculos;

    public Garaje() {
    }

    public Garaje(String ID, List<Vehiculo> vehiculos) {
        this.ID = ID;
        this.vehiculos = vehiculos;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
