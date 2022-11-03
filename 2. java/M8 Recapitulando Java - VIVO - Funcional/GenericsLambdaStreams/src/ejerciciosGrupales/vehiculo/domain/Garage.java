package ejerciciosGrupales.vehiculo.domain;

import java.util.List;

public class Garage {
    private Integer id;
    private List<Vehiculo> vehiculos;

    public Garage() {
    }

    public Garage(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
