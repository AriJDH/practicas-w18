package competencia;

import java.util.*;

public class Carrera {
    private int nroInscriptos = 0;
    private Map<Circuito, Map<Integer, List<String>>> listadosParticipantes = new HashMap<>();

    public List<String> crearPersona(String dni, String nombre, String apellido, String edad, String celular, String numeroDeEmergencia, String
            grupoSanguineo) {
        List<String> persona = new ArrayList<>();
        persona.add(dni);
        persona.add(nombre);
        persona.add(apellido);
        persona.add(edad);
        persona.add(celular);
        persona.add(numeroDeEmergencia);
        persona.add(grupoSanguineo);
        return persona;
    }

    public boolean puedeParticipar(Circuito circuito, boolean mayorDeEdad) {
        return (!circuito.equals(Circuito.AVANZADO) || mayorDeEdad);
    }

    public void inscribirParticipante(Circuito circuito, List<String> persona) {
        Map<Integer, List<String>> listadoCat = listadosParticipantes.getOrDefault(circuito, new HashMap<>());
        listadoCat.put(++nroInscriptos, persona);
        listadosParticipantes.put(circuito, listadoCat);
    }

    public boolean esMayorDeEdad(String edadStr){
        int edad = Integer.parseInt(edadStr);
        return edad >=18;
    }

    public void mostrarPrecioAbono(Circuito circuito, boolean mayorDeEdad) {
        float abono = 0;
        switch(circuito) {
            case CHICO:
                abono = mayorDeEdad ? 1500 : 1300;
                break;
            case MEDIO:
                abono = mayorDeEdad ? 2300 : 2000;
                break;
            case AVANZADO:
                abono = 2800;
                break;
        }
        System.out.println("---------------------------------------");
        System.out.println("El participante "+ nroInscriptos +" debe abonar $" + abono);
        System.out.println("---------------------------------------");
    }

    public void desinscribirParticipante(Circuito circuito, Integer nroDeInscripcion) {
        listadosParticipantes.get(circuito).remove(nroDeInscripcion);
    }

    public void mostrarInscriptos(Circuito circuito) {
        System.out.println("------Circuito "+ circuito.toString() + "------");
        if (listadosParticipantes.containsKey(circuito)){
            Map<Integer, List<String>> inscriptos = listadosParticipantes.get(circuito);
            for (Map.Entry<Integer, List<String>> entrada : inscriptos.entrySet()) {
                System.out.println("Participante " + entrada.getKey() + ":");
                System.out.println("\tDNI: " + entrada.getValue().get(0));
                System.out.println("\tNombre: " + entrada.getValue().get(1));
                System.out.println("\tApellido: " + entrada.getValue().get(2));
                System.out.println("\tEdad: " + entrada.getValue().get(3));
                System.out.println("\tCelular: " + entrada.getValue().get(4));
                System.out.println("\tNro Emergencia: " + entrada.getValue().get(5));
                System.out.println("\tGrupo Sanguineo: " + entrada.getValue().get(6));
            }
        }
    }

    public static void main(String[] args) {
        Carrera appCarrera = new Carrera();
        int opcion;
        String dni, nombre, apellido, edad, celular, numeroDeEmergencia, grupoSanguineo;
        boolean esMayor;
        List<String> datosPersona;
        Circuito circuito;
        int participanteADesinscribir;
        Scanner input = new Scanner(System.in);

        System.out.println("----Carrera de la Selva----");
        do {
            System.out.println("1. Inscribir participante 2. Desinscribir participante 0. SALIR");
            opcion = input.nextInt();
            input.nextLine();

            switch(opcion){
                case 0:
                    // Termina Inscripcion
                    System.out.println("Inscripcion finalizada!");
                    break;
                case 1:
                    // Inscripcion de participante
                    System.out.println("Elija un circuito: 0.Chico 1.Medio 2.Avanzado");
                    circuito = Circuito.values()[input.nextInt()];
                    input.nextLine();
                    System.out.print("Edad: ");
                    edad = input.nextLine();
                    esMayor = appCarrera.esMayorDeEdad(edad);
                    if (appCarrera.puedeParticipar(circuito, esMayor)) {
                        System.out.print("Nombre: ");
                        nombre = input.nextLine();
                        System.out.print("Apellido: ");
                        apellido = input.nextLine();
                        System.out.print("DNI: ");
                        dni = input.nextLine();
                        System.out.print("Celular: ");
                        celular = input.nextLine();
                        System.out.print("Numero de Emergencia: ");
                        numeroDeEmergencia = input.nextLine();
                        System.out.print("Grupo sanguineo: ");
                        grupoSanguineo = input.nextLine();

                        datosPersona = appCarrera.crearPersona(dni,nombre,apellido,edad,celular,numeroDeEmergencia,grupoSanguineo);
                        appCarrera.inscribirParticipante(circuito, datosPersona);
                        appCarrera.mostrarPrecioAbono(circuito, esMayor);

                    } else {
                        System.out.println("Debes ser mayor de edad para participar en el Circuito Avanzado");
                        System.out.println("---------------------------------------");

                    }
                    break;
                case 2:
                    // Desinscribir
                    System.out.print("Elija el circuito: 0.Chico 1.Medio 2.Avanzado: ");
                    circuito = Circuito.values()[input.nextInt()];
                    System.out.print("Nro de participante a desinscribir: ");
                    participanteADesinscribir = input.nextInt();
                    input.nextLine();
                    appCarrera.desinscribirParticipante(circuito, participanteADesinscribir);
                    System.out.println("Participante "+ participanteADesinscribir + " eliminado!");
                    break;
                default:
                    System.out.println("Opcion Invalida!! Pruebe de nuevo");
            }

        } while (opcion!=0);
        input.close();

        // Finalizadas las inscripciones, muestra el listado de inscriptos de cada categoria
        appCarrera.mostrarInscriptos(Circuito.CHICO);
        appCarrera.mostrarInscriptos(Circuito.MEDIO);
        appCarrera.mostrarInscriptos(Circuito.AVANZADO);

    }
}
