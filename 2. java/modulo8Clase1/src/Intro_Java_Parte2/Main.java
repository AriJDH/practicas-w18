package Intro_Java_Parte2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Boolean> P1B = new ArrayList<Boolean>();
        List<Boolean> P2B = new ArrayList<Boolean>();
        List<Boolean> P3B = new ArrayList<Boolean>();
        List<String[]> P1D = new ArrayList<String[]>();
        List<String[]> P2D = new ArrayList<String[]>();
        List<String[]> P3D = new ArrayList<String[]>();
        String dni, nombre, apellido, edad, celular, numEme, grupoS;
        int cir;
        Scanner in = new Scanner(System.in);


        while (true) {
            System.out.println("Ingrese operación: \n");
            System.out.println("1- Inscribir \n");
            System.out.println("2- Desinscribir \n");
            System.out.println("3- Determinar monto \n");
            System.out.println("4- Mostrar");
            int op = in.nextInt();
            in.nextLine();
            if (op == 1) {
                System.out.println("DNI: ");
                dni = in.nextLine();

                System.out.println("Nombre: ");
                nombre = in.nextLine();

                System.out.println("Apellido: ");
                apellido = in.nextLine();

                System.out.println("Edad: ");
                edad = in.nextLine();

                System.out.println("Celular: ");
                celular = in.nextLine();

                System.out.println("Número de emergencia: ");
                numEme = in.nextLine();

                System.out.println("Grupo sanguineo: ");
                grupoS = in.nextLine();

                System.out.println("Circuito al que se inscribe: \n");
                System.out.println("1- Chico \n");
                System.out.println("2- Mediano \n");
                System.out.println("3- Grande ");
                cir = in.nextInt();
                in.nextLine();
                if (cir == 1) {
                    P1B.add(true);
                    String[] data = {dni, nombre, apellido, edad, celular, numEme, grupoS};
                    P1D.add(data);
                    System.out.println("Se ha inscripto al circuito chico \n");
                } else if (cir == 2) {
                    P2B.add(true);
                    String[] data = {dni, nombre, apellido, edad, celular, numEme, grupoS};
                    P2D.add(data);
                    System.out.println("Se ha inscripto al circuito mediano \n");
                } else if (cir == 3) {
                    if (Integer.parseInt(edad) >= 18) {
                        P3B.add(true);
                        String[] data = {dni, nombre, apellido, edad, celular, numEme, grupoS};
                        P3D.add(data);
                        System.out.println("Se ha inscripto al circuito grande \n");
                    } else {
                        System.out.println("Usted es menor de edad para este circuito\n");
                    }
                } else {
                    System.out.println("Ingrese un circuito válido \n");
                }
            } else if (op == 2) {
                System.out.println("Numero de circuito: \n");
                System.out.println("1- Chico \n");
                System.out.println("2- Mediano \n");
                System.out.println("3- Grande ");
                cir = in.nextInt();
                System.out.println("Numero de participante: ");
                int nroPart = in.nextInt();
                if (cir == 1) {
                    if (nroPart < P1B.size()) {
                        P1B.set(nroPart, false);
                    } else {
                        System.out.println("Ingrese un número de participante válido\n");
                    }
                } else if (cir == 2) {
                    if (nroPart < P2B.size()) {
                        P2B.set(nroPart, false);
                    } else {
                        System.out.println("Ingrese un número de participante válido\n");
                    }
                } else if (cir == 3) {
                    if (nroPart < P3B.size()) {
                        P3B.set(nroPart, false);
                    } else {
                        System.out.println("Ingrese un número de participante válido\n");
                    }
                } else {
                    System.out.println("Ingrese un circuito válido\n");
                }
            } else if (op == 3) {
                System.out.println("Numero de circuito: \n");
                System.out.println("1- Chico \n");
                System.out.println("2- Mediano \n");
                System.out.println("3- Grande ");
                cir = in.nextInt();
                System.out.println("Numero de participante: ");
                int nroPart = in.nextInt();
                if (nroPart >= 0) {
                    if ((cir == 1) && (nroPart < P1B.size())) {
                        if (P1B.get(nroPart)) {
                            int edadPart = Integer.parseInt(P1D.get(nroPart)[3]);
                            if (edadPart >= 18) {
                                System.out.println("El monto a abonar es: 1500$\n");
                            } else {
                                System.out.println("El monto a abonar es: 1300$\n");
                            }
                        } else {
                            System.out.println("El participante no se encuentra en la carrera\n");
                        }
                    } else if ((cir == 2) && (nroPart < P2B.size())) {
                        if (P2B.get(nroPart)) {
                            int edadPart = Integer.parseInt(P2D.get(nroPart)[3]);
                            if (edadPart >= 18) {
                                System.out.println("El monto a abonar es: 2300$\n");
                            } else {
                                System.out.println("El monto a abonar es: 2000$\n");
                            }
                        } else {
                            System.out.println("El participante no se encuentra en la carrera\n");
                        }
                    } else if ((cir == 3) && (nroPart < P3B.size())) {
                        if (P3B.get(nroPart)) {
                            System.out.println("El monto a abonar es: 2800$\n");
                        } else {
                            System.out.println("El participante no se encuentra en la carrera\n");
                        }
                    } else {
                        System.out.println("Ingrese un circuito válido\n");
                    }
                } else {
                    System.out.println("Ingrese un circuito válido\n");
                }
            } else if (op == 4) {
                System.out.println("Circuito que deséa ver: \n");
                System.out.println("1- Chico \n");
                System.out.println("2- Mediano \n");
                System.out.println("3- Grande ");
                cir = in.nextInt();
                if (cir == 1) {
                    for (int i = 0; i < P1B.size(); i++) {
                        if (P1B.get(i)) {
                            System.out.println("Participante: " + P1D.get(i)[0] + "," + P1D.get(i)[1] + "," + P1D.get(i)[2] + "," + P1D.get(i)[3] + "," + P1D.get(i)[4] + "," + P1D.get(i)[5] + "," + P1D.get(i)[6] + "\n");
                        }
                    }
                } else if (cir == 2) {
                    for (int i = 0; i < P2B.size(); i++) {
                        if (P2B.get(i)) {
                            System.out.println("Participante: " + P2D.get(i)[0] + "," + P2D.get(i)[1] + "," + P2D.get(i)[2] + "," + P2D.get(i)[3] + "," + P2D.get(i)[4] + "," + P2D.get(i)[5] + "," + P2D.get(i)[6] + "\n");
                        }
                    }
                } else if (cir == 3) {
                    for (int i = 0; i < P3B.size(); i++) {
                        if (P3B.get(i)) {
                            System.out.println("Participante: " + P3D.get(i)[0] + "," + P3D.get(i)[1] + "," + P3D.get(i)[2] + "," + P3D.get(i)[3] + "," + P3D.get(i)[4] + "," + P3D.get(i)[5] + "," + P3D.get(i)[6] + "\n");
                        }
                    }
                } else {
                    System.out.println("Ingrese un circuito válido\n");
                }
            } else {
                System.out.println("Ingrese una operación válida \n");
            }

        }

    }
}
