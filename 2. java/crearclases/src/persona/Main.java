package persona;

public class Main {
    public static void main(String[] args) {

        Persona personaUno = new Persona();

        Persona personaDos = new Persona("Miguel", 44, 1234567);

        Persona personaTres = new Persona("Adrián", 24, 1234567, 84.00, 1.62);

        int imc = personaTres.calcularIMC();

        boolean esMayorDeEdad = personaTres.esMayorDeEdad();

        System.out.println("índice de masa corporal(IMC)..: " + imc);
        if (imc == -1) {
            System.out.println("es menor a 20..: peso bajo");
        } else if (imc == 0) {
            System.out.println("imc entre 20 y 25..:  peso saludable");
        } else {
            System.out.println("imc mayor a 25..: sobrepeso");
        }
        if (esMayorDeEdad) {
            System.out.println("mayor de edad..: verdadero");
        } else {
            System.out.println("mayor de edad..: falso");
        }
    }

}
