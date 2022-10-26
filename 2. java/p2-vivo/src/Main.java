import java.util.*;

public class Main {
    static Scanner keyboard = new Scanner(System.in);
    static int numeroParticipante = 0;
    static LinkedList<HashMap<String, String>> listaPersonasChico = new LinkedList<>();
    static LinkedList<HashMap<String, String>> listaPersonasMedio = new LinkedList<>();
    static LinkedList<HashMap<String, String>> listaPersonasAvanzado = new LinkedList<>();

    public static void incribir() {
        HashMap<String, String> peopleMap = new HashMap<>();
        String[] datos = new String[] {"dni", "nombre", "apellido", "edad", "celular", "número de emergencia", "grupo sanguíneo"};

        peopleMap.put("ID", String.valueOf(numeroParticipante));
        numeroParticipante++;
        for (String dato : datos) {
            System.out.println("Ingresar " + dato + ":");
            String inputDato = keyboard.next();
            peopleMap.put(dato, inputDato);
        }

        System.out.println("1 - Inscripción Circuito chico");
        System.out.println("2 - Inscripción Circuito medio");
        System.out.println("3 - Inscripción Circuito Avanzado");
        System.out.println("Ingresar una opcion:");
        int categoria = keyboard.nextInt();

        int abono = 0;
        switch(categoria) {
            case 1:
                if (Integer.parseInt(peopleMap.get("edad")) < 18) {
                    abono = 1300;
                } else {
                    abono = 1500;
                }
                listaPersonasChico.add(peopleMap);
                break;
            case 2:
                if (Integer.parseInt(peopleMap.get("edad")) < 18) {
                    abono = 2000;
                } else {
                    abono = 2300;
                }
                listaPersonasMedio.add(peopleMap);
                break;
            case 3:
                if (Integer.parseInt(peopleMap.get("edad")) > 18) {
                    abono = 2800;
                    listaPersonasAvanzado.add(peopleMap);
                } else {
                    System.out.println("Participante menor de edad para este circuito");
                }
                break;
            default:
                System.out.println("Numero incorrecto");
        }
        System.out.println("Abono=" + abono);
    }

    public static void imprimirLista(LinkedList<HashMap<String, String>> listaPersonas) {
        for (HashMap<String, String> persona : listaPersonas) {
            System.out.println("--------");
            for (Map.Entry<String, String> personaItem : persona.entrySet()) {
                System.out.println(personaItem.getKey() + ": " + personaItem.getValue());
            }
        }
        System.out.println("--------");
    }

    public static void mostrar() {
        System.out.println("1 - Inscripción Circuito chico");
        System.out.println("2 - Inscripción Circuito medio");
        System.out.println("3 - Inscripción Circuito Avanzado");
        System.out.println("Ingresar una opcion:");
        int categoria = keyboard.nextInt();

        switch(categoria) {
            case 1:
                imprimirLista(listaPersonasChico);
                break;
            case 2:
                imprimirLista(listaPersonasMedio);
                break;
            case 3:
                imprimirLista(listaPersonasAvanzado);
                break;
            default:
                System.out.println("Numero incorrecto");
        }
    }

    public static void desinscribir() {
        System.out.println("Ingresar el número de participante:");
        String numeroParticipanteBorrar = keyboard.next();
        listaPersonasChico.removeIf(persona -> persona.get("ID").equals(numeroParticipanteBorrar));
        listaPersonasMedio.removeIf(persona -> persona.get("ID").equals(numeroParticipanteBorrar));
        listaPersonasAvanzado.removeIf(persona -> persona.get("ID").equals(numeroParticipanteBorrar));
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("1 - Inscribir a un nuevo participante en una categoría");
            System.out.println("2 - Mostrar por pantalla todos los inscriptos");
            System.out.println("3 - Desinscribir a un participante de una categoría");
            System.out.println("4 - Finalizar");
            System.out.println("Ingresar una opcion:");
            int opcion = keyboard.nextInt();
            switch (opcion) {
                case 1:
                    incribir();
                    break;
                case 2:
                    mostrar();
                    break;
                case 3:
                    desinscribir();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Numero incorrecto");
            }
            System.out.println("===============================");
        }
    }
}
