package clases;

public class Cliente {
    private static int siguienteId= 1;

    private String nombre;
    private int id;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.id = siguienteId;
        siguienteId++;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "Cliente: "+ this.id + " Nombre: "+ this.nombre+".";
    }
}
