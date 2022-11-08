import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        Juego juego = new Juego();

        do {
            do {
                System.out.println("//**-------------------------------------------------------------------------**//");
                System.out.println("//**------------------------------------Asteroid-------------------------------------**//");
                System.out.println("------------------------------------------MENU--------------------------------------------");
                System.out.println("OPCION 1: Iniciar Juego");
                System.out.println("OPCION 2: SALIR");
                opcion = entrada.nextInt();

                if(opcion!=1 && opcion!=2)
                    System.out.println("Ingrese una opcion correcta");

                switch (opcion){
                    case 1:
                        juego.iniciarJuego();
                        Jugador j = juego.ganador();
                        juego.mostrarHistorial();
                        juego.mostrarGanador(j);
                }

            }while(opcion!=1 && opcion!=2);
        }while (opcion!=1 && opcion!=2);
    }
}