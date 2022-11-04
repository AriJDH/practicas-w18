package SeriesNumericas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion, opcion2, valorInicial;
        boolean flag1=true, flag2=true;
        Scanner teclado = new Scanner(System.in);


        while(true){
            System.out.println("Elige una serie: ");
            System.out.println("1) Serie de 2.\n2) Serie de 3.\n3) Salir.");
            opcion = teclado.nextInt();

            switch (opcion){
                case 1:{
                    Serie2 serie2 = new Serie2();

                    while(flag1){
                        System.out.println("Elige una opción para la serie de 2: ");
                        System.out.println("1) Establecer un valor inicial.\n2) Mostrar siguiente valor.\n3) Reiniciar serie.\n4) Salir.");
                        opcion2 = teclado.nextInt();

                        switch (opcion2) {
                            case 1: {
                                System.out.println("Ingresa cual sera el valor inicial: ");
                                valorInicial = teclado.nextInt();
                                serie2.valorInicial(valorInicial);
                            }
                            break;
                            case 2: {
                                System.out.println("El siguiente valor es : " + serie2.siguienteValor());
                            }
                            break;
                            case 3: {
                                serie2.reiniciarSerie();
                            }
                            break;
                            case 4:
                                flag1 = false;
                                break;
                            default:
                                System.out.println("Opcion incorrecta!");
                        }
                    }
                }break;
                case 2:{
                    Serie3 serie3 = new Serie3();

                    while(flag2){

                        System.out.println("Elige una opción para la serie de 3: ");
                        System.out.println("1) Establecer un valor inicial.\n2) Mostrar siguiente valor.\n3) Reiniciar serie.\n4) Salir.");
                        opcion2 = teclado.nextInt();

                        switch (opcion2) {
                            case 1: {
                                System.out.println("Ingresa cual sera el valor inicial: ");
                                valorInicial = teclado.nextInt();
                                serie3.valorInicial(valorInicial);
                            }
                            break;
                            case 2: {
                                System.out.println("El siguiente valor es : " + serie3.siguienteValor());
                            }
                            break;
                            case 3: {
                                serie3.reiniciarSerie();
                            }
                            break;
                            case 4:
                                flag2 = false;
                                break;
                            default:
                                System.out.println("Opcion incorrecta!");
                         }
                    }
                }break;
                case 3: System.exit(0);
                default:
                    System.out.println("Opcion incorrecta!");
            }

        }
    }
}
