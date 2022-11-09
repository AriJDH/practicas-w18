package clase3_b_EjerComplementarios.Ej2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    static Scanner teclado = new Scanner(System.in);
    private static List<INave> listaNavesYFlotas = new ArrayList<>();
    private static List<Coordenada> listaCoordenadas = new ArrayList<>();
    public static void menuAsteroid(){
        int opcion = 0;
        do {
            System.out.println("-----------------------------------------");
            System.out.println("Ingrese su opción:");
            System.out.println("-----------------------------------------\n");
            System.out.println("1 - Nueva Nave");
            System.out.println("2 - Nueva Flota de naves");
            System.out.println("3 - Ingresar coordenadas");
            System.out.println("4 - Iniciar juego");
            System.out.println("\n0 - Salir");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1: nuevaNave();
                    break;
                case 2: nuevaFlota();
                    break;
                case 3: nuevaCoordenada();
                    break;
                case 4: inicioJuego();
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

    private static void inicioJuego() {
        if (listaNavesYFlotas.isEmpty()){
            System.out.println("Debe ingresar naves/flotas para iniciar el juego");
            System.out.println("\nPresione una tecla para continuar...");
            teclado.nextLine();
        } else if (listaCoordenadas.isEmpty()){
            System.out.println("Debe ingresar las coordenadas para iniciar el juego");
            System.out.println("\nPresione una tecla para continuar...");
            teclado.nextLine();
        } else {
            calcularDistanciasYPuntuaciones();
            mostrarGanador();
            mostrarResultados();
        }
    }

    private static void calcularDistanciasYPuntuaciones() {
        double distancia, distanciaMinima;
        int posDistanciaMinima;
        for ( Coordenada coordenada : listaCoordenadas ){
            posDistanciaMinima = 0;
            distanciaMinima = listaNavesYFlotas.get(posDistanciaMinima).calcularDistancia(coordenada.getX(), coordenada.getY());
            for( int i = 0; i < listaNavesYFlotas.size(); i++){
                distancia = listaNavesYFlotas.get(i).calcularDistancia(coordenada.getX(), coordenada.getY());
                coordenada.setResultado(distancia); //asigno resultado de distancia de esa nave para esa coordenada.
                if (distancia < distanciaMinima) {
                    posDistanciaMinima = i;
                    distanciaMinima = listaNavesYFlotas.get(posDistanciaMinima).calcularDistancia(coordenada.getX(), coordenada.getY());
                }
            }
            listaNavesYFlotas.get(posDistanciaMinima).setPuntuacion(); // le asigno el punto a la nave/flota más cercana a la coordenada
        }
    }

    private static void mostrarGanador(){
        int posMax=0;
        for( int i = 0; i < listaNavesYFlotas.size(); i++){
            if(listaNavesYFlotas.get(i).getPuntaje() > listaNavesYFlotas.get(posMax).getPuntaje()){
                posMax = i;
            }
        }
        System.out.println("\n-----------------------------------------");
        System.out.print("El ganador es la nave/flota '" + listaNavesYFlotas.get(posMax).getNombre() + "' con " + listaNavesYFlotas.get(posMax).getPuntaje() + " puntos.");
        System.out.println("\n-----------------------------------------");
    }
    private static void mostrarResultados(){
        for(Coordenada coordenada : listaCoordenadas){
            System.out.println("-----------------------------------------");
            System.out.println(coordenada);
        }
        System.out.println("-----------------------------------------");
    }
    private static void nuevaCoordenada() {
        char opcion;
        int x, y;
        do {
            System.out.println("\n-----------------------------------------");
            System.out.print("Coordenada x: ");
            x = teclado.nextInt();
            teclado.nextLine();
            System.out.print("Coordenada y: ");
            y = teclado.nextInt();
            listaCoordenadas.add(new Coordenada(x,y));
            System.out.print("\nDesea registrar otra coordenada al juego? (S/N): ");
            opcion = teclado.next().charAt(0);
        } while ((opcion == 'S' || opcion == 's' ));
        System.out.println("\nPresione una tecla para continuar...");
        teclado.nextLine();
    }

    public static void nuevaNave(){
        String nombre;
        int x, y;
        System.out.println("\n-----------------------------------------");
        System.out.print("Nombre de nave: ");
        nombre = teclado.nextLine();
        System.out.print("Coordenada x: ");
        x = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Coordenada y: ");
        y = teclado.nextInt();
        teclado.nextLine();
        listaNavesYFlotas.add(new Nave(nombre, x, y));
    }

    public static void nuevaFlota(){
        char opcion;
        String nombre;
        System.out.println("-----------------------------------------");
        System.out.print("Nombre de la flota: ");
        nombre = teclado.nextLine();
        System.out.println("-----------------------------------------");
        Flota flota = new Flota(nombre);
        int x, y;
        do{
            System.out.println("\n------------------------------------------------------------------------");
            System.out.print("Nombre de la nave correspondiente a la flota '" + flota.getNombre() + "': ");
            nombre = teclado.nextLine();
            System.out.print("Coordenada x: ");
            x = teclado.nextInt();
            teclado.nextLine();
            System.out.print("Coordenada y: ");
            y = teclado.nextInt();
            teclado.nextLine();
            flota.add(new Nave(nombre, x, y));
            System.out.print("\nDesea registrar otra nave a la flota? (S/N): ");
            opcion = teclado.next().charAt(0);
            teclado.nextLine();
        } while ((opcion == 'S' || opcion == 's' ));
        listaNavesYFlotas.add(flota);
        System.out.println("\nPresione una tecla para continuar...");
        teclado.nextLine();
    }

    public static void main(String[] args) {
        menuAsteroid();
    }

}
