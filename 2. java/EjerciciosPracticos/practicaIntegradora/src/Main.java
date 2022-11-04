//---------------------------- Ejercicio 3 - Main ----------------------------
public class Main {
    public static void main(String[] args) {

        // ------------------------------------------ Ejercicio 4------------------------------------------

        //Objeto sin parametros
        Persona persona1 = new Persona();

        //Objeto con nombre,edad, dni
        Persona persona2 = new Persona("Carlos","30","7890");

        //Objeto con todos los datos
        Persona persona3 = new Persona("Juan","19","2345",80,1.59);

        //Objeto con nombre y edad
        Persona persona4 = new Persona("Natalia", "23");

        //------------------------------------------ Ejercicio 5 ------------------------------------------

        System.out.println("\nLa información de la persona es:");
        System.out.println(persona3);

        //----------Pongo a prueba el método IMC
        System.out.println("\nPrueba método IMC");
        persona3.calcularIMC();

        //----------Pongo a prueba el método esMayorDeEdad
        System.out.println(" ");
        System.out.println("Prueba método esMayorDeEdad");
        persona3.esMayorDeEdad();



    }
}