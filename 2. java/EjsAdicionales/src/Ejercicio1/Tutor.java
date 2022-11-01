package Ejercicio1;

public class Tutor extends Estudiante implements Docente {
    private String nombre;
    private String materia;

    public Tutor(String nombre, String materia){
        super(nombre);
        this.materia = materia;
    }

    @Override
    public void dictarMateria() {
        System.out.println("Materia dictada por un tutor");
    }
}
