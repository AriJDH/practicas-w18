package Turismo.Clases;

import Turismo.Interfaces.IRepository;

public class Cliente {
    private String nombre;
    private String dni;
    private int countReservas;

    public int getCountReservas() {
        return countReservas;
    }

    public void setCountReservas(int countReservas) {
        this.countReservas += countReservas;
    }

    public Cliente(String nombre, String dni) {
        setNombre(nombre);
        setNni(dni);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNni() {
        return dni;
    }

    public void setNni(String dni) {
        this.dni = dni;
    }


}
