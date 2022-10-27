import models.Persona;

public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Federico",26,"10000000");
        Persona persona3 = new Persona("Pepe",30,"2000000",70.6,1.82);
//        Persona persona4 = new Persona("Juan",40);

        int imc = persona3.calcularIMC();
        boolean mayorEdad = persona3.esMayorDeEdad();

        if (imc == -1) {
            System.out.println(persona3.getName() + " tiene un bajo peso.");
        } else if (imc == 0) {
            System.out.println(persona3.getName() + " tiene un peso saludable.");
        } else {
            System.out.println(persona3.getName() + " tiene sobrepeso.");
        }

        if (mayorEdad) {
            System.out.println(persona3.getName() + " es mayor de edad.");
        } else {
            System.out.println(persona3.getName() + " es menor de edad.");
        }

        System.out.println(persona3.toString());
    }
}