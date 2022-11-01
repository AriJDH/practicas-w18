import Clases.Gato;
import Clases.Perro;
import Clases.Vaca;
import Interfaces.ComerAnimal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion=0;
        Scanner teclado = new Scanner(System.in);
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        while(true){
            System.out.println("Elige un animal: \n1) Perro.\n2) Gato.\n3) Vaca.\n4) Salir.");
            opcion = teclado.nextInt();

            switch (opcion){
                case 1:{
                    System.out.println("PERRO: ");
                    perro.emitirSonido();
                    //perro.comerCarne(); //metodo de la interfaz Carnivoro
                    ComerAnimal.comerAnimal(perro); //Metodo estatico de la interfaz ComerAnimal
                    System.out.println();
                }break;
                case 2:{
                    System.out.println("GATO: ");
                    gato.emitirSonido();
                    //gato.comerCarne(); //metodo de la interfaz Carnivoro
                    ComerAnimal.comerAnimal(gato); //Metodo estatico de la interfaz ComerAnimal
                    System.out.println();
                }break;
                case 3:{
                    System.out.println("VACA: ");
                    vaca.emitirSonido();
                    //vaca.comerHierba(); //Metodo de la interfaz Herviboro
                    ComerAnimal.comerAnimal(vaca); //Metodo estatico de la interfaz ComerAnimal
                    System.out.println();
                }break;
                case 4: System.exit(0);
                default:{
                    System.out.println("Opcion incorrecta!");
                    System.out.println();
                }

            }

        }

    }
}
