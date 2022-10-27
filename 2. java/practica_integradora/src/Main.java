public class Main {

    public static void main(String[] args) {

        System.out.println("Práctica integradora");

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Carlos", 42, "43920393");
        Persona persona3 = new Persona("Manuela", 63, "84958734", 58,1.62);

        persona3.cacularIMC();
        persona3.esMayorDeEdad();
        persona3.toString();

    }
}
