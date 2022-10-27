public class Main {
    public static void main(String[] args) {
        Persona Jonathan = new Persona();
        Persona Leila = new Persona("Leila", 40, "29329039");
        Persona Lucas = new Persona("Lucas", 25, "40333444", 60, 1.70 );

        System.out.println("Índice de masa corporal (IMC): " + Lucas.calcularIMC());
    }
}