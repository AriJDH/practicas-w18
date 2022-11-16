import EjercicioSeriesNumericas.Clases.Serie2;
import EjercicioSeriesNumericas.Clases.Serie3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion1, opcion2, valorInicial;
        boolean flag1 = true, flag2 = true;
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Para comenzar elija una de las series:");
            System.out.println("1) Serie de 2, 2) Serie de 3, 3) Salir");
            System.out.println("Ingrese su opción:");
            opcion1 = scan.nextInt();

            switch (opcion1) {
                case 1:
                    Serie2 newSerie2 = new Serie2();
                    while (flag1) {
                        System.out.println("Elija una opción:");
                        System.out.println("1)Ingresar valor inicial, 2) Devolver siguiente, 3) Resetear, 4)Salir");
                        System.out.println("Ingrese su opción:");
                        opcion2 = scan.nextInt();

                        switch (opcion2) {
                            case 1:
                                System.out.println("Ingrese su valor inicial:");
                                valorInicial = scan.nextInt();
                                newSerie2.primerValor(valorInicial);
                                break;

                            case 2:
                                System.out.println("El siguiente valor es: "+ newSerie2.devolverSiguiente());
                                break;

                            case 3:
                                newSerie2.reiniciar();
                                break;

                            case 4:
                                flag1= false;
                                break;

                            default:
                                System.out.println("Opcion incorrecta.");
                                break;
                        }
                    }

                case 2:
                    Serie3 newSerie3= new Serie3();

                    while (flag2) {
                        System.out.println("Elija una opción:");
                        System.out.println("1)Ingresar valor inicial, 2) Devolver siguiente, 3) Resetear, 4)Salir");
                        System.out.println("Ingrese su opción:");
                        opcion2 = scan.nextInt();

                        switch (opcion2) {
                            case 1:
                                System.out.println("Ingrese su valor inicial:");
                                valorInicial = scan.nextInt();
                                newSerie3.primerValor(valorInicial);
                                break;

                            case 2:
                                System.out.println("El siguiente valor es: "+ newSerie3.devolverSiguiente());
                                break;

                            case 3:
                                newSerie3.reiniciar();
                                break;

                            case 4:
                                flag2= false;
                                break;

                            default:
                                System.out.println("Opcion incorrecta.");
                                break;
                        }
                    }

                case 3:
                    System.exit(0);
                    break;

                case 4:
                    System.out.println("Opcion incorrecta.");
                    break;

            }
        }

    }
}