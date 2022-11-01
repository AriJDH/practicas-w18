package Ejercicio2;

public class Curriculum implements Imprimible {

    private String  nombre;
    private int edad;
    private String profesion;
    private String tecnologia;

    public Curriculum(String nombre, int edad, String profesion, String tecnologia) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
        this.tecnologia = tecnologia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String experienciaLabora) {
        this.profesion = experienciaLabora;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    @Override
    public void imprimirDocumentos() {
        System.out.println("Nombre: " +  this.nombre);
        System.out.println("Edad: " +  this.edad);
        System.out.println("Profesion: " +  this.profesion);
        System.out.println("Tecnologias: " + this.tecnologia);
    }
}
