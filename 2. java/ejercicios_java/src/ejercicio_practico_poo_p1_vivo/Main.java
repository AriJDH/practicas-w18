package ejercicio_practico_poo_p1_vivo;

public class Main {

    public static void main(String[] args) {

        Persona persona = new Persona();
        persona.setDni("1237272");
        persona.setAltura(13.3f);
        persona.setEdad("12");
        persona.setNombre("Dizzi");
        persona.setPeso(13.3f);

        Persona personaMateo = new Persona("Mateo", "12", "1020202");

        Persona personaCristian = new Persona("Cristian", "23", "1020202", 72f, 1.83f);

        int imc = personaCristian.calcularIMC();

        boolean esMayorEdad = personaCristian.esMayorDeEdad();

        if (imc == -1) {
            System.out.println("Bajo peso");
        } else if (imc == 0) {
            System.out.println("Peso saludable");
        } else {
            System.out.println("Sobrepeso");
        }
    }
}
