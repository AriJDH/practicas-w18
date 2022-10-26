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

        while (true) {
            System.out.println("---------- Carrera selva -------");
            System.out.println("A). Inscribir participante.");
            System.out.println("B). Mostrar participantes por categoria.");
            System.out.println("C). Desinscribir participante de categoria.");
            System.out.println("D). Determinar monto a abonar.");

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
                default:
                    System.out.println("No se ingreso una opción valida");
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

        Map<String, String> participante = new HashMap<>();

        participante.put("DNI", "10000");
        participante.put("nombre", "10000");
        participante.put("apellido", "10000");
        participante.put("celular", "10000");
        participante.put("numero", "10000");
        participante.put("grupoSanguineo", "10000");

        switch (opcionCategoria) {

            case 1:
                circuitoChico.add(participante);
                break;
            case 2:
                circuitoMedio.add(participante);
                break;
            case 3:
                circuitoAvanzado.add(participante);
                break;
            default:
                System.out.println("Opción no valida");
                break;
        }

    }
}
