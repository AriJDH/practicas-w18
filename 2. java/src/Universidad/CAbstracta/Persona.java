package Universidad.CAbstracta;

public abstract class Persona {
    String Nombre;
    int Edad;

    public Persona(String nombre, int edad) {
        this.setNombre(nombre);
        this.setEdad(edad);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Nombre='" + this.getNombre() + '\'' +
                ", Edad=" + this.getEdad() +
                '}';
    }

}