public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Vanessa", "28", "123456");
        Persona persona3 = new Persona("Juan", "17", "789012", 70, 1.70);

        int imc = persona3.calcularIMC();
        boolean mayorEdad = persona3.esMayorDeEdad();

        if (mayorEdad) {
            System.out.println(persona3.getNombre() + " es mayor de edad");
        } else {
            System.out.println(persona3.getNombre() + " es menor de edad");
        }

        switch (imc) {
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
        }

        System.out.println(persona3);
    }
}