import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int maxTemp = 0;
        int minTemp = 0;
        ArrayList<Temperatura> listaClaseTemp = new ArrayList<Temperatura>();
        int continuar;
        do {

            System.out.println("Ingrese una ciudad");
            String ciudad = teclado.nextLine();

            System.out.println("Ingrese la temperatura Maxima");
            try{
                maxTemp = Integer.valueOf(teclado.nextLine());
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
            System.out.println("Ingrese la temperatura Minima");
            try{
                minTemp = Integer.valueOf(teclado.nextLine());
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
            System.out.println("Ingrese 1 - para cargar una ciudad. \n 2 - para salir");
            continuar = teclado.nextInt();
            teclado.nextLine();
            Temperatura auxClaseTemp = new Temperatura(ciudad, maxTemp, minTemp);
            listaClaseTemp.add(auxClaseTemp);


        }
        while(continuar == 1);

        TemperaturaGlobal listaAComparar = new TemperaturaGlobal(listaClaseTemp);
        System.out.println("La ciudad con mayor temperatura es " + listaAComparar.getTemGlobalMax().getCiudad()
                + " con una temperatura de " + listaAComparar.getTemGlobalMax().getMaxTemp() +
                " ºC y la ciudad de " + listaAComparar.getTemGlobalMin().getCiudad() +
                " tiene una temperatura de " + listaAComparar.getTemGlobalMin().getMinTemp() +
                " ºC siendo esta tenperatura la mas baja");

    }
}
