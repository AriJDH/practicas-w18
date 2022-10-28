package distribuidora;
import java.util.ArrayList;

public class Distribuidora {
    public static void main(String [] args){
        ArrayList<Producto> productos = new ArrayList<>();
        NoPerecedero arroz = new NoPerecedero("arroz", 300, "cereal");
        Perecedero yogur = new Perecedero("yogur", 100, 2);
        NoPerecedero harina = new NoPerecedero("harina", 200, "harina");
        Perecedero queso = new Perecedero("queso", 600, 4);
        productos.add(arroz);
        productos.add(yogur);
        productos.add(harina);
        productos.add(queso);

        float acuPerecedero = 0;
        float acuNoPerecedero = 0;

        for(Producto producto: productos){
            if(producto instanceof Perecedero){
                acuPerecedero += producto.calcular(5);
            }
            if(producto instanceof NoPerecedero){
                acuNoPerecedero += producto.calcular(5);
            }
        }
        System.out.println("Total alimentos perecederos: " + acuPerecedero);
        System.out.println("Total alimentos no perecederos: " + acuNoPerecedero);
    }
}
