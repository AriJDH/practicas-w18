package clases;

import java.util.Optional;
import java.util.UUID;

public class Producto {

    private String id;
    private String producto;
    private double costoUnitario;

    public Producto(String id, String producto, double costoUnitario, RepositorioProductos repositorio) {

        Optional<Producto> filtroProducto = repositorio.getProductos().stream()
                .filter(elemento -> elemento.getId() == id)
                .findFirst();

        if (filtroProducto.isEmpty()) {
            this.id = id;
            this.producto = producto;
            this.costoUnitario = costoUnitario;
        }
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "Producto..: \n" +
                "id='" + id + '\n' +
                "producto='" + producto + '\n' +
                "costoUnitario=" + costoUnitario;
    }
}
