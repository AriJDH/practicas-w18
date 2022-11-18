public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Tana",15,"25222");
        Persona persona3 = new Persona("Ignacio",20,"30000",75,1.75f);

        // No es posible construir una persona solo con su nombre y edad ya que no contamos con un constructor específico.

        System.out.println(persona3.calcularIMC());
        System.out.println(persona3.esMayorEdad());
        System.out.println("De acuerdo al IMC la persona está en la categoría '"+persona3.descripcionIMC(persona3.calcularIMC())+"'.");
    }
}