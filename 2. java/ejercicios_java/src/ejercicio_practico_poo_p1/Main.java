package ejercicio_practico_poo_p1;

public class Main {

    public static void main(String[] args) {

        Persona persona = new Persona();
        persona.setDni("1237272");
        persona.setAltura(13.3f);
        persona.setEdad("12");
        persona.setNombre("Dizzi");
        persona.setPeso(13.3f);

        Persona personaMateo = new Persona("Mateo", "12", "1020202");

        Persona personaCristian = new Persona("Cristian", "23", "1020202", 54.2f, 1.42f);


    }
}
