package clases;

import java.util.List;

public class Cliente {
    private List<Factura> facturas;
    private String nombre;
    private String apellido;
    private String dni;

    public Cliente() {
    }

    public Cliente(List<Factura> facturas, String nombre, String apellido, String dni) {
        this.facturas = facturas;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "facturas=" + facturas +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }

    public int facturasAcumuladas(){
        return facturas.size();
    }
}
