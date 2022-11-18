
/*CONSIGNA
 * https://docs.google.com/document/d/1p0dsoyA-4xXG-nc1-eQ20UxB1fL3DguMGQNL8lV96rw/edit
 * */

import java.util.*;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {

        System.out.println("------------- Carrera de la Selva -------------");

        getCategorias(participantesCircuitoChico, participantesCircuitoMedio, participantesCircuitoAvanzado);

        mostrarMenuPrincipal();

        sc.close();

    }


    static Scanner sc = new Scanner(System.in);
    static List<Object> participantesCircuitoChico = new ArrayList<>();
    static List<Object> participantesCircuitoMedio = new ArrayList<>();
    static List<Object> participantesCircuitoAvanzado = new ArrayList<>();


    static Map<Integer, List<Object>> categorias;

    public static void getCategorias(List<Object> participantesCircuitoChico,
                                     List<Object> participantesCircuitoMedio,
                                     List<Object> participantesCircuitoAvanzado) {
        categorias = new HashMap<>();
        categorias.put(1, participantesCircuitoChico);
        categorias.put(2, participantesCircuitoMedio);
        categorias.put(3, participantesCircuitoAvanzado);

    }

    //para tener participantes por nroInscripción
    static HashMap<Integer, List> participantes = new HashMap<>();


    //Para designar un número de participante consecutivo
    static Integer nroParticipante = 0;

    public enum CategoriaCircuito {
        CIRCUITO_CHICO, CIRCUITO_MEDIO, CIRCUITO_AVANZADO

        /*
         * La competencia cuenta con 3 categorías dependiendo de su dificultad:
         * Circuito chico: 2 km por selva y arroyos.
         * Circuito medio: 5 km por selva, arroyos y barro.
         * Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra.
         * */

    }

    private static void mostrarMenuPrincipal() {

        System.out.println("1. Inscribir participante");
        //Cada categoría tiene un listado de inscriptos diferente

        //Categoría: sólo puede incribirse en una categoría

        //Datos inscripción:
        // dni
        // nombre
        // apellido
        // edad
        // celular
        // nro emergencia
        // grupo sanguíneo

        // Asignación de un nroInscripcion consecutivo incremental

        // Para finalizar la inscripción se debe calcular el monto

        System.out.println("2. Mostrar participantes por Categoría");
        // Mostrar inscriptos de una determinada categoría, cada quien con sus datos y nroInscripción

        System.out.println("3. Mostrar Todos los participantes");

        System.out.println("4. Desinscribir participante");
        // de una categoría -> pedir categoría como dato de entrada para recorrer listado por categoría y eliminarlo

        System.out.println("0. Salir");

        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                ingresarParticipantes();
                break;
            case 2:
                mostrarParticipantes();
                break;
            case 3:
                mostrarTodosLosParticipantes();
                break;
            case 4:
                desinscribirPartipante();
                break;
            case 0:
                exit(0);
        }
        mostrarMenuPrincipal();
    }

    private static void ingresarParticipantes() {
        List participanteInscp1 = inscripcion("tana", "cing", "123", 18, "261", "261", "A-");
        List participanteInscp2 = inscripcion("Icc", "cing", "123", 18, "261", "261", "A-");
        List participanteInscp3 = inscripcion("Mari", "cing", "123", 18, "261", "261", "A-");
        List participanteInscp4 = inscripcion("Susi", "cing", "123", 19, "261", "261", "A-");
        List participanteInscp5 = inscripcion("Gachi", "cing", "123", 19, "261", "261", "A-");
        List participanteInscp6 = inscripcion("Pachi", "cing", "123", 19, "261", "261", "A-");
    }

    private static void mostrarTodosLosParticipantes() {
        //recorro todos los participantes
        for (Integer clave : participantes.keySet()) {
            List participante = participantes.get(clave);
            System.out.print("Nº Part: " + clave);
            System.out.println(" - " + participante);
        }
    }

    private static void mostrarParticipantes() {

        System.out.println("\nParticipantes Circuito Chico");
        for (Object participante : participantesCircuitoChico) {
            System.out.println(participante);
        }

        System.out.println("\nParticipantes Circuito Medio");
        for (Object participante : participantesCircuitoMedio) {
            System.out.println(participante);
        }

        System.out.println("\nParticipantes Circuito Avanzado");
        for (Object participante : participantesCircuitoAvanzado) {
            System.out.println(participante);
        }

    }

    private static Enum<CategoriaCircuito> ingresarCategoria() {
        System.out.print("Ingrese Categoría > ");
        int nroCategoria = sc.nextInt();  //todo acordarse de cerrarlo
        Enum<CategoriaCircuito> categoria = null;

        switch (nroCategoria) {
            case 1:
                categoria = CategoriaCircuito.CIRCUITO_CHICO;
                break;
            case 2:
                categoria = CategoriaCircuito.CIRCUITO_MEDIO;
                break;
            case 3:
                categoria = CategoriaCircuito.CIRCUITO_AVANZADO;
                break;
        }
        return categoria;
    }

    private static int monto(int edad, Enum<CategoriaCircuito> categoria) {
        int monto = 0;
        /*
         * Inscripción Circuito chico: Menores de 18 años $1300. Mayores de 18 años $1500.
         * Inscripción Circuito medio: Menores de 18 años $2000. Mayores de 18 años $2300.
         * Inscripción Circuito Avanzado: No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800
         * */

        boolean mayorEdad = esMayorEdad(edad);


/*        switch (categoria.ordinal()+1){
            case 1:
                return mayorEdad?1500:1300;
            case 2:
                return mayorEdad?2300:2000;
            default:
                return 2800;
        }*/

        if (mayorEdad) {
            if (categoria.equals(CategoriaCircuito.CIRCUITO_CHICO)) {
                monto = 1500;
            }
            if (categoria.equals(CategoriaCircuito.CIRCUITO_MEDIO)) {
                monto = 2300;
            }
            if (categoria.equals(CategoriaCircuito.CIRCUITO_AVANZADO)) {
                monto = 2800;
            }
        } else {
            if (categoria.equals(CategoriaCircuito.CIRCUITO_CHICO)) {
                monto = 1300;
            }
            if (categoria.equals(CategoriaCircuito.CIRCUITO_MEDIO)) {
                monto = 2000;
            }
            if (categoria.equals(CategoriaCircuito.CIRCUITO_AVANZADO)) {
                System.out.println("No se permiten inscripciones a menores de 18 años. Reinicie la inscripción");
                ingresarCategoria();
            }
        }
        return monto;
    }

    private static boolean esMayorEdad(int edad) {
        return edad > 18;
    }


    public static List inscripcion(String nombre,
                                   String apellido,
                                   String dni,
                                   Integer edad,
                                   String celular,
                                   String nroEmergencia,
                                   String grupoSanguineo) {

        nroParticipante += 1;
        Enum<CategoriaCircuito> categoriaCircuito = ingresarCategoria();
        int monto = monto(edad, categoriaCircuito);
        List participante = List.of(nroParticipante, nombre, apellido, dni, edad, celular, nroEmergencia, grupoSanguineo, categoriaCircuito, monto);


        participantes.put(nroParticipante, participante); //PARA BUSCAR POR NÚMERO DE PARTICIPANTE
        agregarParticipanteACategoria(categoriaCircuito, participante);
        return participante;
    }

    private static void agregarParticipanteACategoria(Enum<CategoriaCircuito> categoriaCircuito, List<Object> participante) {

        if (categoriaCircuito.equals(CategoriaCircuito.CIRCUITO_CHICO)) {
            System.out.println("Categoría Circuito Chico\n");
            categorias.get(1).add(participante);
        }
        if (categoriaCircuito.equals(CategoriaCircuito.CIRCUITO_MEDIO)) {
            System.out.println("Categoría Circuito Medio\n");
            categorias.get(2).add(participante);
        }
        if (categoriaCircuito.equals(CategoriaCircuito.CIRCUITO_AVANZADO)) {
            System.out.println("Categoría Circuito Avanzado\n");
            categorias.get(3).add(participante);
        }

    }

    private static void desinscribirPartipante() {

        System.out.println("Ingrese categoría del participante");
        mostrarCategorias();
        CategoriaCircuito categoria = (CategoriaCircuito) ingresarCategoria();

        System.out.println("Ingrese número de participante a desinscribir");
        Integer nroParticipanteDescinscribir = sc.nextInt();


        switch (categoria) {
            case CIRCUITO_CHICO:
                for (Object participante : participantesCircuitoChico) {
                    List p = (List) participante;
                    System.out.println(p.get(0));
                    System.out.println(participante);

                    if (p.get(0) == nroParticipanteDescinscribir) {
                        System.out.println("Lo encontre");
                        participantesCircuitoChico.remove(participante);
                    }
                }
                break;

            case CIRCUITO_MEDIO:
                for (Object participante : participantesCircuitoMedio) {
                    List p = (List) participante;

                    if (p.get(0) == nroParticipanteDescinscribir) {
                        System.out.println("Lo encontre");
                        participantesCircuitoMedio.remove(participante);
                    }
                }
                break;

            case CIRCUITO_AVANZADO:
                for (Object participante : participantesCircuitoAvanzado) {
                    List p = (List) participante;

                    if (p.get(0) == nroParticipanteDescinscribir) {
                        System.out.println("Lo encontre");
                        participantesCircuitoAvanzado.remove(participante);
                    }
                }
                break;
        }


        //remuevo del listado a través de nroParticipante
        Iterator<Map.Entry<Integer, List>> it = participantes.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().equals(nroParticipanteDescinscribir)) {
                System.out.println(participantes.get(it));
                it.remove();
            }
        }

        mostrarTodosLosParticipantes();

    }


    private static void mostrarCategorias() {
        System.out.println("1. Circuito Chico");
        System.out.println("2. Circuito Medio");
        System.out.println("3. Circuito Avanzado");
    }

}

