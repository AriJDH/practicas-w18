import Clases.FlotaNaves;
import Clases.NaveSimple;
import Interfaces.INave;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Asteroid {
    public static void main(String[] args) {
        Random random = new Random();
        int[] coord;
        int opcion=0, opcion2, x1, y1;
        String nombre;
        Scanner teclado = new Scanner(System.in);

        ArrayList<INave> listaJugadores = new ArrayList<>();
        ArrayList<Double> listaDistancias = new ArrayList<Double>();

        while(true){
            System.out.println("----------ASTEREOID----------");
            System.out.println("Elige una opcion: ");
            System.out.println("1) Inscribir participante.\n2) Comenzar juego.\n3) Salir.");
            opcion = teclado.nextInt();

            switch(opcion){
                case 1:{
                    System.out.println("Ingresa tu nombre: ");
                    teclado.nextLine();
                    nombre = teclado.nextLine();
                    System.out.println("Elige 1) para una nave simple o 2) para una flota de 3 naves.");
                    opcion2 = teclado.nextInt();
                    switch(opcion2){
                        case 1:{
                            System.out.println("Ingresa un valor entero para la posicion X: ");
                            x1 = teclado.nextInt();
                            System.out.println("Ingresa un valor entero para la posicion Y: ");
                            y1 = teclado.nextInt();
                            INave naveSimple = new NaveSimple(nombre,x1,y1);
                            listaJugadores.add(naveSimple);
                        }break;
                        case 2:{
                            INave flotaNave = new FlotaNaves(nombre);
                            for(int i=0; i<3; i++){
                                System.out.println("Ingresa un valor entero para la posicion X de la nave "+(i+1)+": ");
                                x1 = teclado.nextInt();
                                System.out.println("Ingresa un valor entero para la posicion y de la nave "+(i+1)+": ");
                                y1 = teclado.nextInt();
                                INave naveSimple = new NaveSimple(" ",x1,y1);
                                flotaNave.add(naveSimple);
                            }
                            listaJugadores.add(flotaNave);
                        }break;
                        default:
                            System.out.println("Opcion Incorrecta!");
                    }
                }break;
                case 2:{
                    coord = new int[] {random.nextInt(10),random.nextInt(10)};
                    for(INave nave : listaJugadores){
                        System.out.println("Distancia de Nave "+nave.getNombre()+": "+nave.calcularDistancia(coord));
                        listaDistancias.add((double) nave.calcularDistancia(coord));
                    }
                    Double minimo = listaDistancias.get(0);
                    int indice=0;

                    for(int i=0; i<listaDistancias.size(); i++){
                        if(minimo > listaDistancias.get(i)){
                            minimo = listaDistancias.get(i);
                            indice = i;
                        }
                    }
                    System.out.println("El ganador es: "+listaJugadores.get(indice).getNombre()+" Puntuacion +1!!");
                    listaJugadores.get(indice).setPuntuacion();
                    System.out.println("////Puntajes///");
                    for(INave naves : listaJugadores){
                        System.out.println(naves.getNombre()+": "+naves.getPuntaje()+" Puntos!");
                    }
                    listaDistancias.clear();

                }break;
                case 3:{
                    System.exit(0);
                }break;
                default:
                    System.out.println("Opcion incorrecta!");
            }
        }

    }
}