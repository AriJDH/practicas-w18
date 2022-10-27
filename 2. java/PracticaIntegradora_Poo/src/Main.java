public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("lucas", 24, "410000");
        Persona persona3 = new Persona("pablo", 42, "3100000", 41.2, 1.74);

        Persona persona4 = new Persona("luis", 42, "3100000", 41.2, 1.74);
        System.out.println(persona4);
        System.out.println(persona4.calcularIMC());
    }
}