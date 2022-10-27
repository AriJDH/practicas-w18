import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        int nro_participante = 0;
        ArrayList< Map< String, String > > participantes = new ArrayList<>();

        int opcion = 1;
        do {

            Scanner sc = new Scanner(System.in);

            System.out.println("Para ingresar competidor presione 1");
            System.out.println("Para mostrar competidores circuito chico 2");
            System.out.println("Para mostrar competidores circuito medio 3");
            System.out.println("para mostrar competidores circuito avanzado 4");
            System.out.println("Para dar de baja un competidor presione 5");
            System.out.println("Para mostrar todos los competidores y los montos 6");
            System.out.println("Para salir presione 7");

            opcion = sc.nextInt();

            mostrarParticipanteCircuito(participantes, "circuito chico");

            switch (opcion) {
                case 1:
                    nro_participante ++;
                    Map<String,String> participante = carga_participante(nro_participante);

                    participantes.add(participante);

                    for (Map.Entry<String, String> entry : participante.entrySet()) {
                        System.out.println(entry.getKey() + ":" + entry.getValue());
                    }
                    break;
                case 2:
                    mostrarParticipanteCircuito(participantes, "circuito chico");
                    break;
                case 3:
                    mostrarParticipanteCircuito(participantes, "circuito medio");
                    break;
                case 4:
                    mostrarParticipanteCircuito(participantes, "circuito avanzado");
                    break;
                case 5:
                    int competidor = 0;
                    System.out.println("ingrese número de participante");
                    competidor = sc.nextInt();
                    eliminarParticipante(participantes, competidor);
                    break;
                case 6:
                    mostrarTodos(participantes);
                    break;
                default:
                    opcion = 7;
                    break;
                }
        } while(opcion != 7);

    }

    public static Map<String, String> carga_participante(int nro_participante) {
        Map<String, String> participante = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("ingrese nombre..:");
        String nombre = sc.nextLine();

        System.out.println("ingrese DNI..:");
        long dni = sc.nextLong();

        String apellido = "";

        while (apellido.length() < 3) {
            System.out.println("ingrese apellido..:");
            apellido = sc.nextLine();
        }

        System.out.println("ingrese edad..:");
        int edad = sc.nextInt();

        System.out.println("ingrese celular..:");
        long celular = sc.nextLong();

        String rh = "";
        do {
            System.out.println("Ingrese factor grupo sanguíneo..:");
            rh = sc.nextLine();
        } while (rh.length() < 1 );

        System.out.println("Ingrese nro de emergencia..:");
        long emergencia = sc.nextLong();

        boolean control = false;
        int circuito = 0;
        while (!control) {
            System.out.println("Ingrese 1 Circuito Chico, 2 Circuito Medio, 3 Circuito Avanzado, menores de 18 solo 1 o 2");
            circuito = sc.nextInt();

            if (edad >= 18) control = true;
            if (edad < 18 && (circuito == 1 || circuito == 2)) control = true;
        }

        participante.put("dni", String.valueOf(dni));
        participante.put("nombre", nombre);
        participante.put("apellido", apellido);
        participante.put("edad", String.valueOf(edad));
        participante.put("celular", String.valueOf(celular));
        participante.put("emergencia", String.valueOf(emergencia));
        participante.put("grupo_sanguineo", rh);
        participante.put("monto", String.valueOf(montoParticipante(circuito, edad)));
        participante.put("nro_participante", String.valueOf(nro_participante));

        switch (circuito) {
            case 1:
                participante.put("circuito", "circuito chico");
                break;
            case 2:
                participante.put("circuito", "circuito medio");
                break;
            case 3:
                participante.put("circuito", "circuito avanzado");
                break;
            default:
                participante.put("circuito", "circuito chico");
                break;
        }

        return participante;
    }

    public static double montoParticipante(int circuito, int edad) {
        double monto = 0.00;

        if ( circuito == 1 && edad < 18 ) {
            monto = 1300.00;
        }

        if (( circuito == 1 || circuito > 3 || circuito < 1) && edad >= 18) {
            monto = 1500.00;
        }

        if (circuito == 2 && edad < 18) {
            monto = 2000.00;
        }

        if (circuito == 2 && edad >= 18 ) {
            monto = 2300.00;
        }

        if (circuito == 3) {
            monto = 2800.00;
        }

        return monto;
    }

    public static void mostrarParticipanteCircuito(ArrayList< Map< String, String > > participantes, String buscarCircuito) {

        for (int i = 0; i < participantes.size(); i++) {
            String nombre = participantes.get(i).get("nombre");
            String nro = participantes.get(i).get("nro_participante");
            String nombreCircuito = participantes.get(i).get("circuito");

            if (nombreCircuito == buscarCircuito) {
                System.out.println("participante..:" + nro + " " + nombre);
            }

        }
    }

    public static void eliminarParticipante(ArrayList< Map< String, String > > participantes, int nro_participante) {
        int indice = -1;
        for (int i = 0; i < participantes.size(); i++) {
            if (participantes.get(i).get("nro_participante") == (String.valueOf(nro_participante))) {
                indice = i;
            }
        }
        if (indice != -1) {
            participantes.remove(indice);
        }
    }

    public static void mostrarTodos(ArrayList< Map< String, String>> participantes) {
        for (int i = 0; i < participantes.size(); i++) {
            System.out.println("Participante número..: " + participantes.get(i).get("nro_participante") );
            System.out.println("Nombre..: " + participantes.get(i).get("nombre"));
            System.out.println("apellido..: " + participantes.get(i).get("apellido"));
            System.out.println("edad..: " + participantes.get(i).get("edad"));
            System.out.println("ciruito..: " + participantes.get(i).get("circuito"));
            System.out.println("monto..: " + participantes.get(i).get("monto"));
        }
    }
}
