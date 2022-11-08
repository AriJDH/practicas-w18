package supermercado_el_economico.clases;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String dni;

    private String nombre;

    private String apellido;

    private List<Factura> facturas;

    public Cliente() {
        this.facturas = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public void crearFacturas(List<Item> items) {

        Factura factura = new Factura();

        factura.crearFactura(this, items);

        this.facturas.add(factura);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", facturas=" + facturas +
                '}';
    }
}
