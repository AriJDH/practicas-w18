public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("pepe",23,"43567890");
        Persona p3 = new Persona("juan",43,"43125678",67.6,1.78);

        System.out.println("El IMC es: " + p2.calcularIMC());
        if(p2.esMayorDeEdad())
            System.out.println("Es mayor de edad");
        else
            System.out.println("No es mayor de edad");
        System.out.println("Los datos completos son: " + p2.toString());
    }
}