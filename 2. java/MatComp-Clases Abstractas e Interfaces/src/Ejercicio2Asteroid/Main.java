/*Ejercicio 2
Un juego llamado Asteroid, consiste en acumular puntos cuando destruye un asteroide. Los participantes pueden
poseer una nave simple o una flota de naves simples. Las naves poseen un nombre, una ubicación en coordenadas
(x, y) y una puntuación inicial de cero. Las flota de naves simples solo poseen una lista de naves simples. Cuando
se indica unas coordenadas, la nave que gana el punto será aquella que esté más cerca, donde la distancia será
la(x1-x2)2+(y1-y2)2 , pero en el caso de una flota de naves, la distancia será el promedio de distancias de las
naves de la flota.
Para poder iniciar el juego, se deben inscribir los participantes en una lista y se inicia el juego cuando se
pasa en forma de arreglo las coordenadas donde los blancos aparecerán. Al finalizar se mostrará la nave o flota
de naves ganadora que acumuló más puntos, también se deberá mostrar los resultados obtenidos para cada coordenada
ingresada.
Para desarrollar este ejercicio, se recomienda el uso de interfaces, con el uso del patrón de diseño Composite.*/

package Ejercicio2Asteroid;

import Ejercicio2Asteroid.Clases.Flota;
import Ejercicio2Asteroid.Clases.Nave;
import Ejercicio2Asteroid.Interfaces.INave;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] coordenadas;
        int opcion1;
        int opcion2;
        int x1;
        int y1;
        String nombre;
        Random random = new Random();
        Scanner scan= new Scanner(System.in);

        ArrayList<INave> participantes= new ArrayList<>();
        ArrayList<Double> listaDistancis= new ArrayList<Double>();

        while (true){
            System.out.println("-------BIENVENIDO A ASTEROIDE--------");
            System.out.println("¿Qué desea hacer?");
            System.out.println("1) Inscribir participante / 2)Comenzar juego / 3)Salir");
            System.out.println("Ingrese su opción: ");
            opcion1= scan.nextInt();

            switch (opcion1){
                case 1:
                    System.out.println("Ingrese su nombre:");
                    nombre= scan.next();
                    System.out.println("Desea: 1) Una nave o 2) Una flota");
                    System.out.println("Ingrese su opción: ");
                    opcion2= scan.nextInt();

                    switch (opcion2){
                        case 1:
                            System.out.println("Ingrese la posición x de la coordenadas de la nave:");
                            x1= scan.nextInt();
                            System.out.println("Ingrese la posición y de la coordenada de la nave: ");
                            y1= scan.nextInt();
                            INave nave= new Nave("nave1", x1, y1);
                            participantes.add(nave);
                            break;

                        case 2:
                            INave flota= new Flota("flota 1");
                            for (int i=0; i<3; i++){
                            System.out.println("Ingrese la posición x de la coordenada de la nave "+ (i+1)+ ":" );
                            x1= scan.nextInt();
                            System.out.println("Ingrese la posición y de la coordenada de la nave "+ (i+1)+ ":");
                            y1= scan.nextInt();
                            INave nave2= new Nave(" ", x1, y1);
                            flota.add(nave2);
                        }
                            participantes.add(flota);
                            break;
                        default:
                            System.out.println("Opcion incorrecta. ");
                            break;
                    }

                case 2:
                    coordenadas = new int[]{ random.nextInt(10), random.nextInt(10)};
                    for (INave nave: participantes){
                        System.out.println("la distancia de la nave "+ nave.getNombre()+ "es: "+ nave.calcularDistancia(coordenadas));
                        listaDistancis.add((double) nave.calcularDistancia(coordenadas));
                    }
                    Double minimo = listaDistancis.get(0);
                    int indice= 0;
                    for (int i=0; i<listaDistancis.size(); i++){
                        if (minimo> listaDistancis.get(i)){
                            minimo= listaDistancis.get(i);
                            indice= i;
                        }
                    }

                    System.out.println("El ganador es: "+ participantes.get(indice).getNombre()+ " Puntuacion +1!!");
                    participantes.get(indice).setPuntuacion();
                    System.out.println("Puntajes:");
                    for (INave nave: participantes){
                        System.out.println(nave.getNombre()+ ": "+ nave.getPuntuacion()+ " puntos!");
                    }
                    listaDistancis.clear();
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }



        }


    }
}
