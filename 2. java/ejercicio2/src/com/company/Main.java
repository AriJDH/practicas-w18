package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {


    /*Menú de opciones para el menu principal del sistema*/
    public static int menuOpciones() {
        Scanner teclado = new Scanner(System.in);
        int op = 0;
        System.out.println("-------OPCIONES-------");
        System.out.println("1- Ingresos datos: ");
        System.out.println("2- Mostrar datos: ");
        System.out.println("3- Desinscribir: ");
        System.out.println("0- Salir: ");
        op = teclado.nextInt();
        teclado.nextLine();

        return op;
    }

    /*Menú de opciones para el menu de categorias de la carrera*/
    public static int menuCategorias() {
        Scanner teclado = new Scanner(System.in);
        int op = 0;

        System.out.println("-------CATEGORIAS-------");
        System.out.println("1- Circuito chico: ");
        System.out.println("2- Circuito medio: ");
        System.out.println("3- Circuito grande: ");
        op = teclado.nextInt();
        teclado.nextLine();

        return op;
    }

    /**/
    public static List<String> ingresoDatos(int nroParticipante) {
        List<String> datos = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese nombre: ");
        datos.add(teclado.nextLine());
        System.out.println("Ingrese apellido: ");
        datos.add(teclado.nextLine());
        System.out.println("Ingrese edad: ");
        datos.add(teclado.nextLine());
        //calcular monto a pagar

        System.out.println("Ingrese celular: ");
        datos.add(teclado.nextLine());
        System.out.println("Ingrese numero de emergencia: ");
        datos.add(teclado.nextLine());
        System.out.println("Ingrese grupo sanguineo: ");
        datos.add(teclado.nextLine());
        System.out.println("Numero de participante: " + nroParticipante);
        datos.add(String.valueOf(nroParticipante));

        return datos;
    }

    public static boolean controlExistencia(int dni, HashMap participantesCC, HashMap participantesCM, HashMap participantesCG) {
        boolean valor = false;

        for (Object x : participantesCC.keySet()) {
            if (x.equals(dni)) {
                valor = true;
                break;
            }
        }
        for (Object x : participantesCM.keySet()) {
            if (x.equals(dni)) {
                valor = true;
                break;
            }
        }
        for (Object x : participantesCG.keySet()) {
            if (x.equals(dni)) {
                valor = true;
                break;
            }
        }
        if (valor == true) {
            System.out.println("Participante existente");
        }

        return valor;
    }

    public static void eliminarParticipante(int dni, HashMap categoria) {
        if (categoria.containsKey(dni)) {
            categoria.remove(dni);
            System.out.println("Eliminacion exitosa");
        }else{
            System.out.println("El participante no se encuentra en esta categoria o no esta inscripto");
        }
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        HashMap<Integer, List<String>> participantesCC = new HashMap();
        HashMap<Integer, List<String>> participantesCM = new HashMap();
        HashMap<Integer, List<String>> participantesCG = new HashMap();

        //lista de categorias
        ArrayList<HashMap> circuitoChico = new ArrayList();
        ArrayList<HashMap> circuitoMedio = new ArrayList();
        ArrayList<HashMap> circuitoGrande = new ArrayList();

        int nroParticipante = 1;
        int opcion = 0;
        int categoria = 0;
        boolean existe = false;

        do {
            opcion = menuOpciones();

            switch (opcion) {
                case 1:
                    categoria = menuCategorias();
                    System.out.println("-------DATOS PARTICIPANTE-------");

                    System.out.println("Ingrese el dni: ");
                    int dni = teclado.nextInt();
                    teclado.nextLine();
                    existe = controlExistencia(dni, participantesCC, participantesCM, participantesCG);
                    if (existe != true) {
                        if (categoria == 1) {
                            participantesCC.put(dni, ingresoDatos(nroParticipante));
                            circuitoChico.add(participantesCC);
                        } else if (categoria == 2) {
                            participantesCM.put(dni, ingresoDatos(nroParticipante));
                            circuitoMedio.add(participantesCC);
                        } else {
                            participantesCG.put(dni, ingresoDatos(nroParticipante));
                            circuitoGrande.add(participantesCC);
                        }
                        nroParticipante = nroParticipante + 1;
                    }

                    break;
                case 2:
                    categoria = menuCategorias();

                    if (categoria == 1) {
                        if (circuitoChico.isEmpty()) {
                            System.out.println("No hay datos para mostrar. ");
                        } else {
                            System.out.println("-------MUESTRA DE INSCRIPTOS CICUITO CHICO-------");
                            for (HashMap x : circuitoChico) {
                                for (int participante : participantesCC.keySet()) {
                                    System.out.println("Datos del participante: " + participante);
                                    for (String d : participantesCC.get(participante)) {
                                        System.out.println(d);
                                    }
                                }
                            }
                        }
                    } else if (categoria == 2) {
                        if (circuitoMedio.isEmpty()) {
                            System.out.println("No hay datos para mostrar. ");
                        } else {
                            System.out.println("-------MUESTRA DE INSCRIPTOS CICUITO MEDIO-------");
                            for (HashMap x : circuitoMedio) {
                                for (int participante : participantesCM.keySet()) {
                                    System.out.println("Datos del participante: " + participante);
                                    for (String d : participantesCM.get(participante)) {
                                        System.out.println(d);
                                    }
                                }
                            }
                        }
                    } else {
                        if (circuitoGrande.isEmpty()) {
                            System.out.println("No hay datos para mostrar. ");
                        } else {
                            System.out.println("-------MUESTRA DE INSCRIPTOS CICUITO GRANDE-------");
                            for (HashMap x : circuitoGrande) {
                                for (int participante : participantesCG.keySet()) {
                                    System.out.println("Datos del participante: " + participante);
                                    for (String d : participantesCG.get(participante)) {
                                        System.out.println(d);
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese DNI a eliminar: ");
                    dni = Integer.parseInt(teclado.nextLine());

                    categoria = menuCategorias();

                    if (categoria == 1) {
                        eliminarParticipante(dni, participantesCC);
                    } else if (categoria == 2) {
                        eliminarParticipante(dni, participantesCM);
                    } else {
                        eliminarParticipante(dni, participantesCG);
                    }
                    break;

                default:
                    break;
            }

        } while (opcion != 0);

    }
}
