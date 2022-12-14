import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class main {
    public static void main(String[] args) throws IOException {

        //Creacion del menu principal y variables de instancias:

        List<Object> listaParticipantes = new ArrayList<>();

        List<Asteroide> listaAsteroides = new ArrayList<Asteroide>();

        List<Double> listaDistancias = new ArrayList<Double>();

        Scanner entrada = new Scanner(System.in);

        int opcion = 0;
        String opcionDos;
        String nombre = "";

        int coordX = 0;
        int coordY = 0;
        double distanciaMenor = 0.0;

        int puntuacionMayor = 0;

        Object ganador = null;

        while(true){
            System.out.println("------------ JUEGO DE ASTEROIDES ----------------");
            System.out.println("Elija una opcion: ");
            System.out.println("1. Añadir participante");
            System.out.println("2. Comenzar juego");
            System.out.println("3. Salir");
            opcion = entrada.nextInt();

            switch (opcion){
                case 1:{

                    System.out.println("Elija una opcion: ");
                    System.out.println("A. Jugar con Nave Simple");
                    System.out.println("B. Jugar con flota de 5 naves.");
                    System.out.println("C. Volver al menu anterior");
                    entrada.skip("\n");
                    opcionDos = entrada.nextLine();

                    switch (opcionDos){
                        case "A" :{
                            System.out.println("Creando nave simple ... \n");
                            System.out.println("Ingrese el nombre del participante: ");
                            nombre = entrada.nextLine();

                            System.out.println("Introduzca las coordenadas de la nave");

                            System.out.println("Posicion en X: ");
                            coordX = entrada.nextInt();

                            System.out.println("");

                            System.out.println("Posicion en Y: ");
                            coordY = entrada.nextInt();

                            //Creacion del objeto Nave Simple
                            NaveSimple nave = new NaveSimple(nombre, coordX, coordY, 0);
                            listaParticipantes.add(nave);

                        }break;

                        case "B" :{
                            System.out.println("Creando flota de naves ... \n");

                            List<NaveSimple>  navesSimples = new ArrayList<NaveSimple>();

                            System.out.println("Ingrese el nombre del participante: ");
                            nombre = entrada.nextLine();

                            for(int i = 0; i<5; i++){

                                System.out.println("Introduzca las coordenadas para la nave: " + (i+1));

                                System.out.println("Posicion en X: ");
                                coordX = entrada.nextInt();

                                System.out.println("");

                                System.out.println("Posicion en Y: ");
                                coordY = entrada.nextInt();

                                NaveSimple nave = new NaveSimple(nombre, coordX, coordY, 0);
                                navesSimples.add(nave);

                            }

                            FlotaDeNaves flota = new FlotaDeNaves(navesSimples);

                            listaParticipantes.add(flota);


                        } break;

                        case "C":{
                            break;
                        }

                        default: {
                            System.out.println("La opcion ingresada es invalida");
                        }break;
                    }

                } break;

                case 2: {
                    System.out.println("Creando asteroid \n");

                    for(int i = 0; i<5; i++){
                        System.out.println("Introduzca las coordenadas del Asteroide: " + (i+1));

                        System.out.println("Posicion en X:");
                        coordX =  entrada.nextInt();


                        System.out.println("Posicion en Y:");
                        coordY = entrada.nextInt();

                        Asteroide asteroide = new Asteroide(coordX, coordY);
                        listaAsteroides.add(asteroide);
                    }

                    for(int i = 0; i<5; i++){
                        System.out.println(listaAsteroides.get(i).getCoordX()+ ", " + listaAsteroides.get(i).getCoordY());
                    }


                    System.out.println("Calculando distancias ...");

                    for(int i=0; i<listaParticipantes.size(); i++) {
                        if (listaParticipantes.get(i) instanceof NaveSimple){

                            //Calculo las distancias para cada Nave Simple y las guardo en una lista
                            for(int j=0; j<listaAsteroides.size(); j++) {
                                listaDistancias.add(((NaveSimple) listaParticipantes.get(i)).calcularDistancia((NaveSimple) listaParticipantes.get(i), listaAsteroides.get(j)));
                                ((NaveSimple) listaParticipantes.get(i)).setDistancia(listaDistancias.get(j));
                            }


                        } else {

                            //Calculo los promedios de distancias para cada nave simple de la flota.
                            for(int j = 0; j<listaAsteroides.size(); j++) {
                                listaDistancias.add(((FlotaDeNaves) listaParticipantes.get(i)).calcularPromedio(listaAsteroides.get(j)));
                                ((FlotaDeNaves) listaParticipantes.get(i)).setPromedio(listaDistancias.get(j));
                            }

                        }

                    }

                    //Busco la distancia menor y la almaceno para poder compararla
                    distanciaMenor = listaDistancias.get(0);
                    for(int j=0; j<listaDistancias.size(); j++) {
                        if(listaDistancias.get(j) <= distanciaMenor) {
                            distanciaMenor = listaDistancias.get(j);
                        }
                    }


                    //Busco cual es el participante que obtuvo la menor distancia y le asigno un punto.

                    for(int i=0; i<listaParticipantes.size(); i++) {
                        if(listaParticipantes.get(i) instanceof NaveSimple) {

                            if(((NaveSimple) listaParticipantes.get(i)).getDistancia() == distanciaMenor){
                                ((NaveSimple) listaParticipantes.get(i)).setPuntuacion(1);
                            }
                        } else {

                            if(((FlotaDeNaves) listaParticipantes.get(i)).getPromedio() == distanciaMenor) {
                                ((FlotaDeNaves) listaParticipantes.get(i)).setPuntuacion(1);
                            }
                        }
                    }

                    //Recorro la lista de participantes y veo cual es el que mayor puntuacion obtuvo.
                    for(int i=0; i<listaParticipantes.size(); i++) {
                        if(listaParticipantes.get(i) instanceof NaveSimple) {

                            if(((NaveSimple) listaParticipantes.get(i)).getPuntuacion() > puntuacionMayor){
                              puntuacionMayor = ((NaveSimple) listaParticipantes.get(i)).getPuntuacion();
                            }
                        } else {

                            if(((FlotaDeNaves) listaParticipantes.get(i)).getPromedio() > puntuacionMayor) {
                                puntuacionMayor = ((FlotaDeNaves) listaParticipantes.get(i)).getPuntuacion();
                            }
                        }
                    }

                    //Recorro todos los participantes y asigno un ganador segun la puntuacion mayor obtenida.
                    for(int i=0; i<listaParticipantes.size(); i++) {
                        if(listaParticipantes.get(i) instanceof NaveSimple) {

                            if(((NaveSimple) listaParticipantes.get(i)).getPuntuacion() == puntuacionMayor){
                                ganador = ((NaveSimple) listaParticipantes.get(i));
                            }
                        } else {

                            if(((FlotaDeNaves) listaParticipantes.get(i)).getPromedio() == puntuacionMayor) {
                                ganador = ((NaveSimple) listaParticipantes.get(i));
                            }
                        }
                    }

                    //Muestro por pantalla los resultados obtenidos para dicho ganador.
                    System.out.println("A continuación se muestra por pantalla los resultados del ganador: " + ganador);


                } break;

                case 3: {
                    System.exit(0);
                } break;

                default:{
                    System.out.println("La opcion ingresada no es valida \n");
                } break;
            }
        }


    }

}
