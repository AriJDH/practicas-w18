package practica_vivo_p2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EjercicioCarrera {


    static ArrayList<Map<String, String>> circuitoChico = new ArrayList<>();
    static ArrayList<Map<String, String>> circuitoMedio = new ArrayList<>();
    static ArrayList<Map<String, String>> circuitoAvanzado = new ArrayList<>();

    public static void main(String[] args) {

        boolean indicadorSalir = false;

        while (true) {
            System.out.println("---------- Carrera selva -------");
            System.out.println("A). Inscribir participante.");
            System.out.println("B). Mostrar participantes por categoria.");
            System.out.println("C). Desinscribir participante de categoria.");
            System.out.println("D). Determinar monto a abonar.");
            System.out.println("E). Salir.");

            Scanner teclado = new Scanner(System.in);

            String opcionMenu = String.valueOf(teclado.nextLine());

            switch (opcionMenu) {
                case "A":
                    crearParticipante();
                    break;
                case "B":
                    break;
                case "C":
                    break;
                case "D":
                    break;
                case "E":
                    System.out.println("-----SE CIERRA EL PROGRAMA---------");
                    indicadorSalir = true;
                    break;
                default:
                    System.out.println("No se ingreso una opción valida");
            }
            
            if (indicadorSalir) {
                break;
            }
        }
    }

    private static void crearParticipante() {

        System.out.println("------Seleccione categoria------");
        System.out.println("1 -> Circuito chico");
        System.out.println("2 -> Circuito medio");
        System.out.println("3 -> Circuito avanzando");

        Scanner teclado = new Scanner(System.in);
        int opcionCategoria = teclado.nextInt();

        System.out.println("Ingrese DNI");
        String dni = teclado.nextLine();

        System.out.println("Ingrese Nombre");
        String nombre = teclado.nextLine();

        System.out.println("Ingrese Apellido");
        String apellido = teclado.nextLine();

        System.out.println("Ingrese Edad");
        String edad = teclado.nextLine();

        System.out.println("Ingrese Celular");
        String celular = teclado.nextLine();

        System.out.println("Ingrese Numero");
        String numero = teclado.nextLine();

        System.out.println("Ingrese Grupo Sanguineo");
        String grupoSanguineo = teclado.nextLine();

        Map<String, String> participante = new HashMap<>();

        participante.put("DNI", dni);
        participante.put("nombre", nombre);
        participante.put("apellido", apellido);
        participante.put("edad", edad);
        participante.put("celular", celular);
        participante.put("numero", numero);
        participante.put("grupoSanguineo", grupoSanguineo);
        int montoAbonar = 0;

        switch (opcionCategoria) {
            case 1:
                //Calcular monto a pagar
                montoAbonar = calcularMontoAbonar(1, Integer.parseInt(edad));
                participante.put("montoAbonar", String.valueOf(montoAbonar));
                circuitoChico.add(participante);
                break;
            case 2:
                //Calcular monto a pagar
                montoAbonar = calcularMontoAbonar(2, Integer.parseInt(edad));
                participante.put("montoAbonar", String.valueOf(montoAbonar));
                circuitoMedio.add(participante);
                break;
            case 3:
                //Calcular monto a pagar
                montoAbonar = calcularMontoAbonar(3, Integer.parseInt(edad));
                participante.put("montoAbonar", String.valueOf(montoAbonar));
                circuitoAvanzado.add(participante);
                break;
            default:
                System.out.println("Opción no valida");
                break;
        }

    }

    private static int calcularMontoAbonar(int categoria, int edad) {

        int montoAbonar = 0;

        if (categoria == 1) {

            if (edad < 18) {
                montoAbonar = 1300;
            } else {
                montoAbonar = 1500;
            }

        } else if(categoria == 2) {
            if (edad < 18) {
                montoAbonar = 2000;
            } else {
                montoAbonar = 2300;
            }
        } else {
            montoAbonar = 2800;
        }

        return montoAbonar;
    }

    private static void consultarParticipantes() {

        System.out.println("------Seleccione categoria------");
        System.out.println("1 -> Circuito chico");
        System.out.println("2 -> Circuito medio");
        System.out.println("3 -> Circuito avanzando");

        Scanner teclado = new Scanner(System.in);
        int opcionCategoria = teclado.nextInt();

        switch (opcionCategoria) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            default:
                System.out.println("Opción no valida");
                break;
        }
    }
}
