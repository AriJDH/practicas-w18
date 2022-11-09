package Clientes;

import Transacciones.Deposito;
import Transacciones.Transferencia;

public abstract class Ejecutivos implements Deposito, Transferencia {
    private String nombre= "";
    private String dni;

    public Basic(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Basic{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
