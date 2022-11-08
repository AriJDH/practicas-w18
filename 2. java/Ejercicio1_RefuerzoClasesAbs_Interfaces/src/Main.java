import Abstract.Persona;
import Class.Personal;


public class Main {
    public static void main(String[] args) {
    Persona tutor1 = new Personal("Pepe Juan", "Materias Basicas", "Tutor");

        System.out.println("Hola soy " + tutor1.getNombreApellido() + " y estoy ejerciciendo mi cargo de " + tutor1.ejercerCargo());

    }
}