public class Main {
    private static String calcularNivelDePeso(int numIMC) {
        if (numIMC == -1) {
            return "Bajo peso";
        } else if (numIMC == 0) {
            return "Peso saludable";
        } else {
            return "Sobrepeso";
        }
    }

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Pepito", 26, "91286491");
        Persona persona3 = new Persona("Fulano", 21, "297642065", 56.0, 162.0);
        // No es posible construirlo pasando solamente un valor para el nombre y otro para la edad en el constructor.
        // - Error: no suitable constructor found...
        System.out.println(">> Persona3");
        System.out.println("Nivel de peso: " + calcularNivelDePeso(persona3.calcularIMC()));
        System.out.println("Es " + (persona3.esMayorDeEdad()? "mayor": "menor") + " de edad");
        System.out.println(persona3.toString());
    }
}