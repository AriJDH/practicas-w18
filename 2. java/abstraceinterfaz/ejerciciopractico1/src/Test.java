import java.util.Scanner;

public  class Test {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double monto;
        int opcion = 0;
        System.out.println("Seleccione opcion de tipo cliente: 1: Ejecutivo 2: Basic 3:Cobradores");
        opcion = Integer.parseInt(entrada.nextLine());
        switch (opcion){

            case 1:
                System.out.println("Implementacion cliente tipo: Ejecutivo");
                System.out.println("Ingresa monto:");
                monto = Double.parseDouble(entrada.nextLine());
                Ejecutivo ejecutivo = new Ejecutivo(monto);
                ejecutivo.hacerDeposito();
                ejecutivo.hacerTransferencia();
                break;
            case 2:
                System.out.println("Implementacion cliente tipo: Basic");
                System.out.println("Ingresa monto:");
                monto = Double.parseDouble(entrada.nextLine());
                Basic basic = new Basic(monto);
                basic.realizaConsultaDeSaldo();
                basic.realizaPagoDeServicios();
                basic.realizaRetiroDeEfectivo();
                break;
            case 3:
                System.out.println("Implementacion cliente tipo: Basic");
                System.out.println("Ingresa monto:");
                monto = Double.parseDouble(entrada.nextLine());
                Cobradores cobradores = new Cobradores(monto);
                cobradores.realizaRetiroDeEfectivo();
                cobradores.realizaConsultaDeSaldo();
                break;
            default:
                System.out.println("Opcion invalida");
        }


    }
}
