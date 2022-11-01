import Clientes.Basic;
import Clientes.Ejecutivo;

import java.util.Scanner;

/*Prueba de algunos casos practicos:
-Selecciona Basic, luego seleccionar Pagar servicio e ingresar el servicio -TEST OK, Se ve reflejado el servicio
-Selecciona Basic y hacer el mismo procedimiento que en el caso anterior para la opcion Retirar efectivo - TEST OK, se ve reflejado el monto efectivo
-Selecciona Ejecutivo y ver que se haga la transferencia - TEST OK
-Selecciona 3 y ver que el sistema salga con exit - TEST OK2
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------BIENVENIDO AL BANCO------------");

        int caso = 0;
        String tipoDeServicio;
        Double monto;
        Scanner teclado = new Scanner(System.in);

        while (true) {
            System.out.println("Identifiquese: \1) Basic. \2)Ejecutivo. \3)Salir");
            caso = teclado.nextInt();

            switch (caso) {
                case 1: {
                    Basic basicNuevo = new Basic();
                    System.out.println("Que desea hacer: \1)Consultar saldo \2)Pagar Servicio. \3)Retirar Efectivo");
                    caso = teclado.nextInt();
                    switch (caso) {
                        case 1: {
                            basicNuevo.consultarSaldo();
                        }
                        break;
                        case 2: {
                            System.out.println("Ingrese servicio");
                            tipoDeServicio = teclado.next();
                            basicNuevo.pagarServicio(tipoDeServicio);
                        }
                        break;
                        case 3: {
                            System.out.println("Ingrese Monto");
                            monto = teclado.nextDouble();
                            basicNuevo.retirarEfectivo(monto);
                        }
                        break;
                        default:
                            System.out.println("Error de opcion ingrese nuevamente");
                    }
                }
                break;
                case 2: {
                    Ejecutivo ejecutivoPrueba = new Ejecutivo();
                    ejecutivoPrueba.hacerTransferencia();
                }
                break;
                case 3:{
                    System.out.println("Usted ha finalizado la sesion");
                    System.exit(0);
                }
                default:
                    System.out.println("Error de opcion, ingrese nuevamente");
            }
            System.out.println("Gracias por utilizar nuestro sistema");
        }
    }

}
