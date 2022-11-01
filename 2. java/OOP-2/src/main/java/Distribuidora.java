import java.util.ArrayList;
import java.util.Scanner;


public class Distribuidora {

    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<Producto>();

        Scanner scanner = new Scanner(System.in);

        double resultado = 0;

        Perecedero leche = new Perecedero("leche", 50);
        Perecedero yogurt = new Perecedero("yogurt",80);
        Perecedero flan = new Perecedero("flan", 40);
        Perecedero chocolate = new Perecedero("chocolate", 20);
        Perecedero pollo = new Perecedero("pollo", 90);

        NoPerecedero arroz = new NoPerecedero("arroz", 30);
        NoPerecedero lataAtun = new NoPerecedero("lata de atún", 20);
        NoPerecedero fideos = new NoPerecedero("fideos", 40);
        NoPerecedero lentejas = new NoPerecedero("lentejas", 25);
        NoPerecedero nueces = new NoPerecedero("nueces", 100);

        leche.setDiasPorCaducar(4);
        yogurt.setDiasPorCaducar(2);
        flan.setDiasPorCaducar(1);
        chocolate.setDiasPorCaducar(3);
        pollo.setDiasPorCaducar(5);

        productos.add(leche);
        productos.add(yogurt);
        productos.add(flan);
        productos.add(chocolate);
        productos.add(pollo);

        productos.add(arroz);
        productos.add(lataAtun);
        productos.add(fideos);
        productos.add(lentejas);
        productos.add(nueces);

        for (Producto producto : productos) {
            boolean noHuboError = false;

            while(!noHuboError) {
                try {
                    System.out.println("Ingrese la cantidad de " + producto.getNombre() + " que va a comprar: ");
                    String cantidadDeProductosRaw = scanner.nextLine();
                    int cantidadDeProductos = Integer.parseInt(cantidadDeProductosRaw);
                    resultado += producto.calcular(cantidadDeProductos);
                    noHuboError = true;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor introduzca un número entero. ");
                    continue;
                }
            }
        }

        System.out.println("La cantidad a pagar es de: " + resultado);

      }

}


