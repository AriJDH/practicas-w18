//Importaciones
import java.util.ArrayList;
import java.util.List;

public class Garaje {

    //Variables
    int id;
    List<Vehiculo> listaVehiculo;

    {
        listaVehiculo = new ArrayList<>();
    }

    //Constructor
    public Garaje(int id, List<Vehiculo> listaVehiculo) {
        this.id = id;
        this.listaVehiculo = listaVehiculo;
    }
    //Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(List<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }
}
