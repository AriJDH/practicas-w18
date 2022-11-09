
/*CONSIGNA
 * https://docs.google.com/document/d/1p0dsoyA-4xXG-nc1-eQ20UxB1fL3DguMGQNL8lV96rw/edit
 * */

import java.util.*;

import static java.lang.System.exit;

public class Main {


    static Scanner sc = new Scanner(System.in);
    static List<String> participantesCircuitoChico = new ArrayList<>();
    static List<Object> participantesCircuitoMedio = new ArrayList<>();
    static List<Object> participantesCircuitoAvanzado = new ArrayList<>();
    static HashMap<Integer, List> participantes = new HashMap<>();

    static Integer nroParticpante = 0;



    public enum CategoriaCircuito {
        CIRCUITO_CHICO, CIRCUITO_MEDIO, CIRCUITO_AVANZADO;

        /*
         * La competencia cuenta con 3 categorías dependiendo de su dificultad:
         * Circuito chico: 2 km por selva y arroyos.
         * Circuito medio: 5 km por selva, arroyos y barro.
         * Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra.
         * */

    }



    public static void main(String[] args) {

        System.out.println("------------- Carrera de la Selva -------------");
        showMenuPrincipal();

    }

    private static void ingresarParticipantes() {
        List participanteInscp1 = inscripcion("tana", "cing", "123", 18, "261", "261", "A-");
        List participanteInscp2 = inscripcion("Icc", "cing", "123", 18, "261", "261", "A-");
        List participanteInscp3 = inscripcion("Mari", "cing", "123", 18, "261", "261", "A-");
        List participanteInscp4 = inscripcion("Susi", "cing", "123", 19, "261", "261", "A-");
        List participanteInscp5 = inscripcion("Gachi", "cing", "123", 19, "261", "261", "A-");
        List participanteInscp6 = inscripcion("Pachi", "cing", "123", 19, "261", "261", "A-");
    }

    private static void mostrarParticipantes() {
        System.out.println("\nParticipantes Circuito Chico");
        for (Object participante: participantesCircuitoChico) {
            System.out.println(participante);
        }

        System.out.println("\nParticipantes Circuito Medio");
        for (Object participante: participantesCircuitoMedio) {
            System.out.println(participante);
        }

        System.out.println("\nParticipantes Circuito Avanzado");
        for (Object participante: participantesCircuitoAvanzado) {
            System.out.println(participante);
        }
    }

/*    private static void mostrarTodos(){
        System.out.println("\nTodos los participantes");
        for (Object participante: todosLosParticipantes) {
            System.out.println(participante);
        }
    }*/


    private static void showMenuPrincipal() {
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

        System.out.println("2. Mostrar participantes");
        // Mostrar inscriptos de una determinada categoría, cada quien con sus datos y nroInscripción

        System.out.println("3. Desinscribir participante");
        // de una categoría -> pedir categoría como dato de entrada para recorrer listado por categoría y eliminarlo

        System.out.println("0. Salir");

        int opcion = sc.nextInt();

        switch (opcion){
            case 1: ingresarParticipantes();

                break;
            case 2: mostrarParticipantes();

                break;
            case 3: desinscribirPartipante();
                break;
            case 0: exit(0);
        }
        showMenuPrincipal();
    }

    //Ingresar categoría para opción 1, 2, 3
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
        //todo implementar método monto con matriz - refactorizar
        /*
        * Inscripción Circuito chico: Menores de 18 años $1300. Mayores de 18 años $1500.
        * Inscripción Circuito medio: Menores de 18 años $2000. Mayores de 18 años $2300.
        * Inscripción Circuito Avanzado: No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800
        * */

        if(esMayorEdad(edad)){
            if(categoria.equals(CategoriaCircuito.CIRCUITO_CHICO)) {
                monto = 1500;
            }
            if (categoria.equals(CategoriaCircuito.CIRCUITO_MEDIO)) {
                monto = 2300;
            }
            if (categoria.equals(CategoriaCircuito.CIRCUITO_AVANZADO)){
                monto = 2800;
            }
        } else {
            if(categoria.equals(CategoriaCircuito.CIRCUITO_CHICO)){
                monto = 1300;
            }
            if (categoria.equals(CategoriaCircuito.CIRCUITO_MEDIO)) {
                monto = 2000;
            }
            if (categoria.equals(CategoriaCircuito.CIRCUITO_AVANZADO)){
                System.out.println("No se permiten inscripciones a menores de 18 años. Reinicie la inscripción");
                ingresarCategoria();
            }
        }
        return monto;
    }

    private static boolean esMayorEdad(int edad){
            return edad > 18;
    }



    public static List inscripcion(String nombre,
                                   String apellido,
                                   String dni,
                                   Integer edad,
                                   String celular,
                                   String nroEmergencia,
                                   String grupoSanguineo){

        nroParticpante +=1;
        Enum<CategoriaCircuito> categoriaCircuito = ingresarCategoria();
        int monto = monto(edad, categoriaCircuito);
        List participante = List.of(nroParticpante, nombre, apellido, dni, edad, celular, nroEmergencia, grupoSanguineo, categoriaCircuito, monto);


        participantes.put(nroParticpante, participante);

        listadoParticipantesPorCategoria(categoriaCircuito, participante);

        return participante;
    }

    private static void listadoParticipantesPorCategoria(Enum<CategoriaCircuito> categoriaCircuito, List<Object> participante) {

        if (categoriaCircuito.equals(CategoriaCircuito.CIRCUITO_CHICO)) {
            System.out.println("Categoría Circuito Chico\n");
            participantesCircuitoChico.add(participante.toString());
        }
        if (categoriaCircuito.equals(CategoriaCircuito.CIRCUITO_MEDIO)){
            System.out.println("Categoría Circuito Medio\n");
            participantesCircuitoMedio.add(participante);
        }
        if (categoriaCircuito.equals(CategoriaCircuito.CIRCUITO_AVANZADO)){
            System.out.println("Categoría Circuito Avanzado\n");
            participantesCircuitoAvanzado.add(participante);
        }

    }
        private static void desinscribirPartipante() {

           //todo
        }

}

