import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Cliente cliente = new Cliente("Pepe",23412345);
//        PaqueteTuristico paquete = new PaqueteTuristico(false,false,false,false,true);
//        PaqueteTuristico paquete2 = new PaqueteTuristico(true,false,true,false,false);
//        List<PaqueteTuristico> paquetes = new ArrayList<PaqueteTuristico>();
//        paquetes.add(paquete);
//        paquetes.add(paquete2);
//        Repositorio repo = new Repositorio(cliente,paquetes);
//        repo.calcularPrecio(paquete);
//        repo.calcularPrecio(paquete2);
//        repo.mostrarReserva(paquete,cliente);

        List<Repositorio> repos = new ArrayList<Repositorio>();
        Repositorio repo = new Repositorio();
        List<PaqueteTuristico> paquetes = new ArrayList<PaqueteTuristico>();

        Scanner entrada = new Scanner(System.in);
        int opcion = 0;


        do {
            do {
                System.out.println("************************Agencia de Viajes******************************");
                System.out.println("-----------------------------MENU-----------------------------------");
                System.out.println("////Ingrese la opciòn////");
                System.out.println("1: Ingrsar Cliente");
                System.out.println("2: Ingresar paquete");
                System.out.println("3: Mostrar reserva");
                System.out.println("99: Salir");
                opcion = entrada.nextInt();
                if ( opcion < 1 || opcion > 3 && opcion != 99)
                    System.out.println("Ingrese una opcion correcta");
                switch (opcion) {
                    case 1:
                        String nombre;
                        int dni;
                        System.out.println("Ingrese Nombre del cliente");
                        entrada.nextLine();
                        nombre = entrada.nextLine();
                        System.out.println("Ingrese el dni del cliente");
                        dni = entrada.nextInt();

                        Cliente cliente = new Cliente(nombre, dni);
                        repo.setCliente(cliente);

                        break;
                    case 2:
                        int op = 0;
                        PaqueteTuristico paquete;
                        boolean hotel= false;
                        boolean comida= false;
                        boolean pasaje= false;
                        boolean transporte= false;
                        boolean completo= false;
                        do {
                            do {
                                System.out.println("Eliga la opcion a reservar");
                                System.out.println("1: Hotal");
                                System.out.println("2: Comida");
                                System.out.println("3: Pasaje");
                                System.out.println("4: Transporte");
                                System.out.println("5: Completo");
                                System.out.println("19: Salir");
                                op = entrada.nextInt();
                                if (op != 19 && op < 1 || op > 5)
                                    System.out.println("Ingrese una opcion correcta");
                                switch (op){
                                    case 1:
                                        hotel = true;
                                        break;
                                    case 2:
                                        comida = true;
                                        break;
                                    case 3:
                                        pasaje = true;
                                        break;
                                    case 4:
                                        transporte = true;
                                        break;
                                    case 5:
                                        completo = true;
                                        break;
                                }

                            } while (op != 19);

                        } while (op != 19);
                        paquete = new PaqueteTuristico(hotel,comida,pasaje,transporte,completo);
                        paquetes.add(paquete);

                        repo.setPaquetes(paquetes);

                        break;
                    case 3:

                        for(PaqueteTuristico p: paquetes){
                            repo.mostrarReserva(p,repo.getCliente());
                        }

                }
            } while (opcion != 99 && opcion > 0 || opcion < 3);
        } while (opcion != 99 && opcion > 0 || opcion < 3);


    }
}