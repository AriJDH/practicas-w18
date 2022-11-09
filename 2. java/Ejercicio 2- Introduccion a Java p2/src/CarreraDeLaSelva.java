import javax.swing.plaf.synth.SynthSpinnerUI;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

import static java.lang.Integer.parseInt;

public class CarreraDeLaSelva {
    static ArrayList<String[]> circuitoChico = new ArrayList<>();
    static ArrayList<String[]> circuitoMedio = new ArrayList<>();
    static ArrayList<String[]> circuitoAvanzado = new ArrayList<>();

    static Scanner scan = new Scanner(System.in);

    public static void inicio(){
        String opcion ="";
        System.out.println(" -----INICIO-------");
        System.out.println("¿Qué desea hacer?");
        System.out.println("A- Inscribir Participante");
        System.out.println("B- Ver listado de participantes por categoría");
        System.out.println("C- Eliminar Participante");
        System.out.println("D- Calcular monto de Inscripción");
        System.out.println("E- Salir");
        System.out.println("Ingrese su opcion: ");

        opcion = scan.next();

        switch (opcion){
            case "A":
                inscribir();
                break;
            case "B":
                listarCategoria();
                break;
            case "C":
                eliminar();
                break;
            case "D":
                monto();
                break;
            case "E":
                System.out.println("Saliendo...");
                System.exit(0);
            default:
                System.out.println("La opción ingresada es incorrecta, intente nuevamente.");
                inicio();
                break;
        }


    }
    public static void inscribir(){

        System.out.println("Ingrese los datos de la inscripción");
        System.out.println("Su DNI sin puntos:");
        String dni= scan.next();
        System.out.println("Su nombre:");
        String nombre = scan.next();
        System.out.println("Su apellido:");
        String apellido = scan.next();
        System.out.println("Su edad:");
        String edad = scan.next();
        System.out.println("Su número de celular:");
        String celular = scan.next();
        System.out.println("Un número de emergencia:");
        String numEmergencia = scan.next();
        System.out.println("Su grupo sanguíneo:");
        String grupoSang = scan.next();

        System.out.println("Ingrese la categoría en la que desee inscribirse");
        System.out.println("1- Circuito chico: 2 km por selva y arroyos.");
        System.out.println("2- Circuito medio: 5 km por selva, arroyos y barro.");
        System.out.println("3- Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra.");
        System.out.println("Ingrese su opcion: ");

        int opcion = scan.nextInt();
        String[] participante = {dni, nombre, apellido, edad, celular, numEmergencia, grupoSang};

        switch (opcion){
            case 1:
                circuitoChico.add(participante);
                inicio();
                break;

            case 2:
                circuitoMedio.add(participante);
                inicio();
                break;

            case 3:
                circuitoAvanzado.add(participante);
                inicio();

            default:
                System.out.println("La opción no corresponde a ninguna categoría, vuelva a intentarlo.");
                inicio();
                break;
        }



    }

    public static void listarCategoria(){
        int opcion;

        System.out.println("Ingrese la categoría que desee listar:");
        System.out.println("1- Circuito chico");
        System.out.println("2- Circuito medio");
        System.out.println("3- Circuito avanzado");
        System.out.println("4- Volver al inicio");
        System.out.println("Ingrese su opcion: ");
        opcion= scan.nextInt();

        switch (opcion) {
            case 1:
                for (int i=0; i< circuitoChico.size(); i++){
                    System.out.println("Participante "+ (i+1) + ": "+ circuitoChico.get(i)[0] + "- "+ circuitoChico.get(i)[1] + "- "+ circuitoChico.get(i)[2] +
                            "- "+ circuitoChico.get(i)[3] + "- "+ circuitoChico.get(i)[4] + "- "+ circuitoChico.get(i)[5] + "- "+ circuitoChico.get(i)[6]);
                }
                System.out.println("Total: "+ circuitoChico.size());
                listarCategoria();
                break;

            case 2:
                for (int i=0; i< circuitoMedio.size(); i++){
                    System.out.println("Participante "+ (i+1) + ": "+ circuitoMedio.get(i)[0] + "- "+ circuitoMedio.get(i)[1] + "- "+ circuitoMedio.get(i)[2] +
                            "- "+ circuitoMedio.get(i)[3] + "- "+ circuitoMedio.get(i)[4] + "- "+ circuitoMedio.get(i)[5] + "- "+ circuitoMedio.get(i)[6]);
                }
                System.out.println("Total: "+ circuitoMedio.size());
                listarCategoria();
                break;

            case 3:
                for (int i=0; i< circuitoAvanzado.size(); i++){
                    System.out.println("Participante "+ (i+1) + ": "+ circuitoAvanzado.get(i)[0] + "- "+ circuitoAvanzado.get(i)[1] + "- "+ circuitoAvanzado.get(i)[2] +
                            "- "+ circuitoAvanzado.get(i)[3] + "- "+ circuitoAvanzado.get(i)[4] + "- "+ circuitoAvanzado.get(i)[5] + "- "+ circuitoAvanzado.get(i)[6]);
                }
                System.out.println("Total: "+ circuitoAvanzado.size());
                listarCategoria();
                break;

            case 4:
                inicio();
                break;

            default:
                System.out.println("La opción ingresada es incorrecta, intente nuevamente.");
                break;
        }

    }

    public static void eliminar(){
        int opcion , nroParticipante;

        System.out.println("de qué categoria desea eliminar un participante?");
        System.out.println("1- Circuito chico");
        System.out.println("2- Circuito medio");
        System.out.println("3- Circuito avanzado");
        System.out.println("4- Volver a Inicio");
        System.out.println("Ingrese su opcion: ");

        opcion= scan.nextInt();

        switch (opcion){
            case 1:
                System.out.println("Ingrese el número de participante a eliminar: ");
                nroParticipante= scan.nextInt();
                circuitoChico.remove(nroParticipante-1);
                System.out.println("Se eliminó al participante número " + nroParticipante);
                System.out.println("Total de participantes en este circuito: "+ circuitoChico.size());
                break;

            case 2:
                System.out.println("Ingrese el número de participante a eliminar: ");
                nroParticipante= scan.nextInt();
                circuitoMedio.remove(nroParticipante-1);
                System.out.println("Se eliminó al participante número " + nroParticipante);
                System.out.println("Total de participantes en este circuito: "+ circuitoMedio.size());
                break;

            case 3:
                System.out.println("Ingrese el número de participante a eliminar: ");
                nroParticipante= scan.nextInt();
                circuitoAvanzado.remove(nroParticipante-1);
                System.out.println("Se eliminó al participante número " + nroParticipante);
                System.out.println("Total de participantes en este circuito: "+ circuitoMedio.size());
                break;

            case 4:
                inicio();
                break;

            default:
                System.out.println("La opción ingresada es incorrecta, intente nuevamente.");
                eliminar();
                break;
        }
    }

    public static void monto(){
        int nroParticipante, monto;
        int circuito;


        System.out.println("Ingrese la categoría del participante que desea abonar:");
        System.out.println("1- Circuito chico");
        System.out.println("2- Circuito medio");
        System.out.println("3- Circuito avanzado");
        System.out.println("4- Volver a Inicio");
        System.out.println("Ingrese su opcion: ");

        circuito= scan.nextInt();

        switch (circuito){
            case 1:
                System.out.println("Ingrese el número de inscripción del participante a abonar:");
                nroParticipante= scan.nextInt();
                if (parseInt(circuitoChico.get(nroParticipante-1)[3]) < 18){
                    monto= 1300;
                    System.out.println("Su monto a pagar es: "+ monto);
                } else if (parseInt(circuitoChico.get(nroParticipante-1)[3]) >= 18) {
                    monto= 1500;
                    System.out.println("Su monto a pagar es: "+ monto);
                }
                monto();
                break;

            case 2:
                System.out.println("Ingrese el número de inscripción del participante a abonar:");
                nroParticipante= scan.nextInt();
                if (parseInt(circuitoMedio.get(nroParticipante-1)[3]) < 18){
                    monto= 2000;
                    System.out.println("Su monto a pagar es: "+ monto);
                } else if (parseInt(circuitoMedio.get(nroParticipante-1)[3]) >= 18) {
                    monto= 2300;
                    System.out.println("Su monto a pagar es: "+ monto);
                }
                monto();
                break;

            case 3:
                System.out.println("Ingrese el número de inscripción del participante a abonar:");
                nroParticipante= scan.nextInt();
                if (parseInt(circuitoAvanzado.get(nroParticipante-1)[3]) < 18){
                    System.out.println("No se admite la inscripción de menores de 18 años");
                } else if (parseInt(circuitoAvanzado.get(nroParticipante-1)[3]) >= 18) {
                    monto= 2800;
                    System.out.println("Su monto a pagar es: "+ monto);
                }
                monto();
                break;

            case 4:
                inicio();

            default:
                System.out.println("La opción ingresada es incorrecta, intente nuevamente.");
                monto();
                break;
        }
        scan.close();
    }


}
