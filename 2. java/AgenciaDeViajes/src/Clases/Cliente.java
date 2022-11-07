package Clases;

public class Cliente {

    private String nombre;
    private int id;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.id = id;

    }

    public int getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "Cliente: "+ this.id + " Nombre: "+ this.nombre+".";
    }
}

