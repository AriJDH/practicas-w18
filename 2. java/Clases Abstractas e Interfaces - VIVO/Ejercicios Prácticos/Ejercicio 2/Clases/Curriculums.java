import java.util.Arrays;

public class Curriculums implements Impresora{

    private String nombre;
    private int edad;
    private String dni;
    private String[] habilidades;

    public Curriculums(String nombre, int edad, String dni, String[] habilidades){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.habilidades = habilidades;
    }



    @Override
    public String toString(){
        return "Curriculum Vitae - Datos personales: " + "\n" +
                "Nombre: " + this.nombre + "\n" +
                "Edad: " + this.edad + "\n" +
                "D.N.I: " + this.dni + "\n" +
                "Habilidades: " + Arrays.toString(habilidades);
    }



}
