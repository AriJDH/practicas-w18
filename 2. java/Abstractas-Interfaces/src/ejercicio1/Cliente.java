package ejercicio1;

public abstract class Cliente {
    String nombre;
    Transaccion[] transacciones;

    public Cliente(String nombre,int cantidad) {
        this.nombre = nombre;
        this.transacciones=new Transaccion[cantidad];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
