package clase1;

import java.util.ArrayList;
import java.util.Scanner;

public class CarreraDeLaSelva {


    public static void inscibir() {

        System.out.println("Ingrese la categoria a la que desea inscribir: ");
        System.out.println("1) Circuito chico: 2 km por selva y arroyos.");
        System.out.println("2) Circuito medio: 5 km por selva, arroyos y barro.");
        System.out.println("3) Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra. NO SE PERMINTEN MENORES DE 18 AÑOS");
        Scanner teclado1 = new Scanner(System.in);
        int opcion = teclado1.nextInt();
        String categoria = "";
        switch(opcion) {
            case 1:
                categoria = "Circuito chico";
                break;
            case 2:
                categoria = "Circuito medio";
                break;
            case 3:
                categoria = "Circuito Avanzado";
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
        }
        teclado1.close();

        System.out.println("Ingrese los datos de la inscripcion");
        Scanner teclado2 = new Scanner(System.in);
        System.out.println("dni: ");
        int dni = teclado2.nextInt();
        System.out.println("nombre: ");
        String nombre = teclado2.nextLine();
        System.out.println("apellido: ");
        String apellido = teclado2.nextLine();
        System.out.println("edad: ");
        int edad = teclado2.nextInt();
        System.out.println("celular: ");
        int celular = teclado2.nextInt();
        System.out.println("nro de emergencia: ");
        int nroEmergencia = teclado2.nextInt();
        System.out.println("grupo sanguineo: ");
        String grupoSanguineo = teclado2.nextLine();
        teclado2.close();

        float costo;
        if(categoria.compareTo("Circuito chico") != 0) {

            if (edad < 18)
                costo = 1300;
            else
                costo = 1500;
        }
        else if(categoria.compareTo("Circuito medio") != 0) {

            if (edad < 18)
                costo = 2000;
            else
                costo = 2300;
        }
        else{
            if (edad < 18)
                System.out.println("No se permite menores de 18 años");
            else
                costo = 2800;
        }



    }


    public void mostrarInscriptos(String categoria) {


    }

    public void desinscribir(String ci, String categoria) {


    }

    public void determinarMonto() {

    }


    public static void main(String[] args) {


    }
}
