public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Nico", 29, "4565432");
        Persona persona3 = new Persona("Carlos", 17, "8965432", 85, 1.90);

        //Persona persona4 = new Persona("Juan", 35);

        System.out.println(persona3);
        persona3.mostrarResultadoIMC();
        persona3.mostrarResultadoMayorDeEdad();


        //System.out.println("Hello world!");
    }
}