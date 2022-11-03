package practica_vivo_p2;

import java.util.*;

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
            System.out.println("D). Salir.");

            Scanner teclado = new Scanner(System.in);

            char opcionMenu = teclado.next().charAt(0);

            switch (opcionMenu) {
                case 'A':
                    crearParticipante();
                    break;
                case 'B':
                    consultarParticipantes();
                    break;
                case 'C':
                    desincribirParticipante();
                    break;
                case 'D':
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
        int opcionCategoria = Integer.valueOf(teclado.nextLine());

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

        int montoAbonar;

        switch (opcionCategoria) {
            case 1:
                //Calcular monto a pagar
                montoAbonar = calcularMontoAbonar(1, Integer.parseInt(edad));
                participante.put("montoAbonar", String.valueOf(montoAbonar));
                participante.put("numeroInscripcion", String.valueOf(circuitoChico.size() + 1));
                circuitoChico.add(participante);
                break;
            case 2:
                //Calcular monto a pagar
                montoAbonar = calcularMontoAbonar(2, Integer.parseInt(edad));
                participante.put("montoAbonar", String.valueOf(montoAbonar));
                participante.put("numeroInscripcion", String.valueOf(circuitoMedio.size() + 1));
                circuitoMedio.add(participante);
                break;
            case 3:
                //Calcular monto a pagar
                montoAbonar = calcularMontoAbonar(3, Integer.parseInt(edad));
                participante.put("montoAbonar", String.valueOf(montoAbonar));
                participante.put("numeroInscripcion", String.valueOf(circuitoAvanzado.size() + 1));
                circuitoAvanzado.add(participante);
                break;
            default:
                System.out.println("Opción no valida");
                break;
        }

    }

    private static int calcularMontoAbonar(int categoria, int edad) {

        int montoAbonar;

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
                imprimirListaParticipante(circuitoChico);
                break;
            case 2:
                imprimirListaParticipante(circuitoMedio);
                break;
            case 3:
                imprimirListaParticipante(circuitoAvanzado);
                break;
            default:
                System.out.println("Opción no valida");
                break;
        }
    }

    private static void imprimirListaParticipante(List<Map<String, String>> listaParticipante) {

        System.out.println("---------INFORMACION PARTICIPANTES----------");
        for (Map<String, String> participante: listaParticipante) {

            for (Map.Entry<String, String> mapaParticipante : participante.entrySet()) {

                System.out.println(mapaParticipante.getKey() + " " + mapaParticipante.getValue());
            }

            System.out.println("================");
        }
    }

    private static void desincribirParticipante() {

        System.out.println("------Seleccione categoria------");
        System.out.println("1 -> Circuito chico");
        System.out.println("2 -> Circuito medio");
        System.out.println("3 -> Circuito avanzando");

        Scanner teclado = new Scanner(System.in);

        int opcionCategoria = Integer.valueOf(teclado.nextLine());

        System.out.println("Ingrese numero de inscripcion del participante");
        int numeroInscripcion = Integer.valueOf(teclado.nextLine());

        switch (opcionCategoria) {
            case 1:
                circuitoChico.removeIf(participante -> participante.get("numeroInscripcion").equals(String.valueOf(numeroInscripcion)));
                break;
            case 2:
                circuitoMedio.removeIf(participante -> participante.get("numeroInscripcion").equals(String.valueOf(numeroInscripcion)));
                break;
            case 3:
                circuitoAvanzado.removeIf(participante -> participante.get("numeroInscripcion").equals(String.valueOf(numeroInscripcion)));
                break;
            default:
                System.out.println("Opción no valida");
                break;
        }
    }

}
