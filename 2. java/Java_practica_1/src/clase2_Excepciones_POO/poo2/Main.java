package clase2_Excepciones_POO.poo2;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Sebastián", 35, "231231231");
        Persona persona3 = new Persona("Sebastián", 35, "231231231", 50.4, 1.72);

        System.out.println(persona3.toString());
        if(persona3.esMayorDeEdad())
            System.out.println("Es mayor de edad");
        else
            System.out.println("No es mayor de edad");

        switch (persona3.cacularIMC()){
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

        System.out.println(persona3.toString());

    }
}
