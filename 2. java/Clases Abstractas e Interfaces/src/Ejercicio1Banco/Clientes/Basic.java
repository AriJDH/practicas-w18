package Ejercicio1Banco.Clientes;


import Ejercicio1Banco.Transacciones.ConsultaDeSaldo;
import Ejercicio1Banco.Transacciones.PagoDeServicios;
import Ejercicio1Banco.Transacciones.RetiroDeEfectivo;

public abstract class Basic implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo {

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

}
