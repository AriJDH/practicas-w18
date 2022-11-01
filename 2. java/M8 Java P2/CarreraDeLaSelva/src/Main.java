
/*CONSIGNA
 * https://docs.google.com/document/d/1p0dsoyA-4xXG-nc1-eQ20UxB1fL3DguMGQNL8lV96rw/edit
 * */

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("------------- Carrera de la Selva -------------");



    }

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

    }


    //Ingresar categoría para opción 1, 2, 3, 4
    private static Enum<CategoriaCircuito> ingresarCategoria() {
        System.out.println("Ingrese Categoría");
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

    private static int monto(int edad, String categoria) {
        int monto = 0;
        //todo implementar método monto con matriz - refactorizar
        /*
        * Inscripción Circuito chico: Menores de 18 años $1300. Mayores de 18 años $1500.
        * Inscripción Circuito medio: Menores de 18 años $2000. Mayores de 18 años $2300.
        * Inscripción Circuito Avanzado: No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800
        * */

        if(esMayorEdad(edad)){
            if(categoria.equals(CategoriaCircuito.CIRCUITO_CHICO)){
                monto = 1500;
            } else if (categoria.equals(CategoriaCircuito.CIRCUITO_MEDIO)) {
                monto = 2300;
            } else {
                monto = 2800;
            }
        } else {
            if(categoria.equals(CategoriaCircuito.CIRCUITO_CHICO)){
                monto = 1300;
            } else if (categoria.equals(CategoriaCircuito.CIRCUITO_MEDIO)) {
                monto = 2000;
            } else {
                System.out.println("No se permiten inscripciones a menores de 18 años.");
            }
        }
        return monto;
    }

    private static boolean esMayorEdad(int edad){
            return edad > 18;
    }

    public enum CategoriaCircuito {
        CIRCUITO_CHICO, CIRCUITO_MEDIO, CIRCUITO_AVANZADO;

        /*
        * La competencia cuenta con 3 categorías dependiendo de su dificultad:
        * Circuito chico: 2 km por selva y arroyos.
        * Circuito medio: 5 km por selva, arroyos y barro.
        * Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra.
        * */

    }



}

