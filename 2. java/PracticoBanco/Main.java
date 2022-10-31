import Clientes.Basic;
import Clientes.Cobradores;
import Clientes.Ejecutivo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion=0;
        Scanner teclado = new Scanner(System.in);

        while(true){
            System.out.println("Selecciona el tipo de cliente: \n1) Basico. \n2) Cobrador. \n3) Ejecutivo.\n4) Salir.");
            opcion = teclado.nextInt();

            switch(opcion){
                case 1: {
                    Basic basico = new Basic();
                    System.out.println("Selecciona el tipo de transacción que deseas realizar:\n1) Consultar saldo.\n2) Pagar servicio.\n3) Retirar efectivo.");
                    opcion = teclado.nextInt();
                    switch(opcion){
                        case 1:{
                            basico.consultarSaldo();
                        }break;
                        case 2:{
                            basico.pagarServicio();
                        }break;
                        case 3:{
                            basico.retirarEfectivo();
                        }break;
                        default:
                            System.out.println("Elige una opción correcta!");
                    }
                }break;
                case 2:{
                    Cobradores cobrador = new Cobradores();
                    System.out.println("Selecciona el tipo de transacción que deseas realizar:\n1) Retirar efectivo.\n2) Consutar saldo.");
                    opcion = teclado.nextInt();
                    switch(opcion){
                        case 1:{
                            cobrador.retirarEfectivo();
                        }break;
                        case 2:{
                            cobrador.consultarSaldo();
                        }break;
                        default:
                            System.out.println("Elige una opción correcta!");
                    }
                }break;
                case 3:{
                    Ejecutivo ejecutivo = new Ejecutivo();
                    System.out.println("Selecciona el tipo de transacción que deseas realizar:\n1) Realizar deposito.\n2) Realizar una transferencia.");
                    opcion = teclado.nextInt();
                    switch(opcion){
                        case 1:{
                            ejecutivo.realizarDeposito();
                        }break;
                        case 2:{
                            ejecutivo.realizarTransferencia();
                        }break;
                        default:
                            System.out.println("Elige una opción correcta!");
                    }
                }break;
                case 4: {
                    System.out.println("Muchas gracias por usar nuestro cajero automático!");
                    System.exit(0);
                }
                default:
                    System.out.println("opcion incorrecta!");
            }
        }

    }
}
