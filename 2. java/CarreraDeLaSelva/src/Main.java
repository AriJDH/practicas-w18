import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Usuario> circuito_chico = new ArrayList<>();
        ArrayList<Usuario> circuito_medio = new ArrayList<>();
        ArrayList<Usuario> circuito_avanzado = new ArrayList<>();

        String exit = "";
        Scanner lec = new Scanner(System.in);

        do{
            System.out.println("Bienvenido a la Carrera de la selva");
            System.out.println("Ingrese su nombre: ");
            String nombre = lec.next();
            System.out.println("Ingrese su apellido: ");
            String apellido = lec.next();
            System.out.println("Ingrese su dni: ");
            String dni = lec.next();
            System.out.println("Ingrese su edad: ");
            int edad = Integer.parseInt(lec.next());
            System.out.println("Ingrese su numero de celular: ");
            String celular = lec.next();
            System.out.println("En que carrera desea particar? ");
            System.out.println("Circuito chico (C)");
            System.out.println("Circuito medio (M)");
            System.out.println("Circuito avanzado (A)");
            String opc = lec.next().toLowerCase().trim();

            int total = 0;

            switch (opc){
                case "c":
                    total = edad >= 18 ?  1500 : 1300;
                    circuito_chico.add(new Usuario(dni, nombre, apellido, edad,celular));
                    break;
                case "m":
                    total = edad >= 18 ? 2300 : 2000;
                    circuito_medio.add(new Usuario(dni, nombre, apellido, edad,celular));
                    break;
                case "a":
                    total = edad >= 18 ? 2800 : null;
                    circuito_avanzado.add(new Usuario(dni, nombre, apellido, edad,celular));
                    break;
                default:
                    System.out.println("Opcion equivocada");
            }

            System.out.println("El total de su incripcion es " + total);
            System.out.println("Desea inscribir a otro participante? (y/n) ");
            String aux = lec.next().toLowerCase().trim();
            System.out.println(aux);
            exit = aux.equals("y") ? "" : "f";



        } while (exit.equals(""));

        for (Usuario usuario : circuito_chico){
            System.out.println("Circuito chico");
            System.out.println(usuario);
        }

        for (Usuario usuario : circuito_medio){
            System.out.println("Circuito chico");
            System.out.println(usuario);
        }

        for (Usuario usuario : circuito_avanzado){
            System.out.println("Circuito avanzado");
            System.out.println(usuario);
        }

    }
}