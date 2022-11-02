package clase3_b_EjerComplementarios.Ej2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    static Scanner teclado = new Scanner(System.in);
    public static void menuAsteroid(){
        int opcion = 0;
        List<Nave> listaNaves = new ArrayList<>();
        List<Flota> listaFlotas = new ArrayList<>();
        List<Coordenada> listaCoordenadas = new ArrayList<>();
        do {
            System.out.println("-----------------------------------------");
            System.out.println("Ingrese su opción:");
            System.out.println("-----------------------------------------\n");
            System.out.println("1 - Nueva Nave");
            System.out.println("2 - Nueva Flota de naves");
            System.out.println("3 - Ingresar coordenadas");
            System.out.println("4 - Iniciar juego");
            System.out.println("0 - Salir");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1: nuevaNave(listaNaves);
                    break;
                case 2: nuevaFlota(listaFlotas);
                    break;
                case 3: nuevaCoordenada(listaCoordenadas);
                    break;
                case 4: puntuaciones(listaNaves, listaFlotas, listaCoordenadas);
                    break;
                case 0: System.out.println("\nPresione una tecla para salir...");
                    teclado.nextLine();
                    break;
                default: System.out.println("\nOpción incorrecta...");
                    break;
            }
        } while (opcion != 0 );
        teclado.close();
    }

    private static void puntuaciones(List<Nave> listaNaves, List<Flota> listaFlotas, List<Coordenada> listaCoordenadas) {
        if (listaFlotas.isEmpty() && listaNaves.isEmpty()){
            System.out.println("Debe ingresar naves/flotas para iniciar el juego");
            System.out.println("\nPresione una tecla para continuar...");
            teclado.nextLine();
        } else if (listaCoordenadas.isEmpty()){
            System.out.println("Debe ingresar las coordenadas para iniciar el juego");
            System.out.println("\nPresione una tecla para continuar...");
            teclado.nextLine();
        } else {

        }
    }

    private static void nuevaCoordenada(List<Coordenada> listaCoordenadas) {
        char opcion;
        int x, y;
        do {
            System.out.println("\n-----------------------------------------");
            System.out.println("Coordenada x: ");
            x = teclado.nextInt();
            teclado.nextLine();
            System.out.println("Coordenada y: ");
            y = teclado.nextInt();
            listaCoordenadas.add(new Coordenada(x,y));
            System.out.println("\nDesea registrar otra coordenada al juego? (S/N)");
            opcion = teclado.next().charAt(0);
        } while ((opcion == 'S' || opcion == 's' ));
        System.out.println("\nPresione una tecla para continuar...");
        teclado.nextLine();
    }

    public static void nuevaNave(List<Nave> listaNaves){
        String nombre;
        int x, y;
        System.out.println("\n-----------------------------------------");
        System.out.println("Nombre de nave: ");
        nombre = teclado.nextLine();
        System.out.println("Coordenada x: ");
        x = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Coordenada y: ");
        y = teclado.nextInt();
        teclado.nextLine();
        listaNaves.add(new Nave(nombre, x, y));
    }

    public static void nuevaFlota(List<Flota> listaFlotas){
        String nombre;
        char opcion;
        Flota flota = new Flota();
        int x, y;
        do{
            System.out.println("\n-----------------------------------------");
            System.out.println("Nombre de nave: ");
            nombre = teclado.nextLine();
            System.out.println("Coordenada x: ");
            x = teclado.nextInt();
            teclado.nextLine();
            System.out.println("Coordenada y: ");
            y = teclado.nextInt();
            teclado.nextLine();
            flota.addNave(new Nave(nombre, x, y));
            System.out.println("\nDesea registrar otra nave a la flota? (S/N)");
            opcion = teclado.next().charAt(0);
            teclado.nextLine();
        } while ((opcion == 'S' || opcion == 's' ));
        listaFlotas.add(flota);
        System.out.println("\nPresione una tecla para continuar...");
        teclado.nextLine();
    }

    public static void main(String[] args) {
        menuAsteroid();
    }

}
