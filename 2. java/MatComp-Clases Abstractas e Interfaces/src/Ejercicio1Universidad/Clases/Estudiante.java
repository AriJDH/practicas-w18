package Ejercicio1Universidad.Clases;

public class Estudiante extends Persona{

    public Estudiante(String nombre, int edad) {
        super(nombre, edad);
    }


    @Override
    public String toString() {
        return "Estudiante{ nombre: "+ getNombre() + ", edad: "+ getEdad();
    }
}
