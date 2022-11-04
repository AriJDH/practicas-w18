public class Main {
    public static void main(String[] args) {

        Persona personaConstructor1 = new Persona();
        Persona personaConstructor2 = new Persona("Nombre", "34", "123456");
        Persona personaConstructor3 = new Persona("Nombre1", "35", "123456789", 87.00, 1.74);
        Persona personaConstructor31 = new Persona("Nombre1", "35", "123456789", 70.00, 1.74);


        // Ejercicio 6 calcular IMC


        personaConstructor3.calcularIMC();
        personaConstructor31.calcularIMC();
        System.out.println("La persona " +
                personaConstructor3.getNombre() + " ¿Es mayor de edad? " +
                personaConstructor3.esMayorDeEdad());
        System.out.println(personaConstructor3);


    }
}