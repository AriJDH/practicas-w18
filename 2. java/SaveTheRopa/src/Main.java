import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> prendas = new ArrayList<>();
        // Crear prenda
        Prenda remera = new Remera("Adidas", "2020");
        Prenda remera2 = new Remera("Nike", "2021");

        prendas.add(remera);
        prendas.add(remera2);

        GuardaRopa gp = new GuardaRopa();

        gp.guardarPrendas(prendas);
        gp.mostrarPrendas();
        List prendas2 = gp.devolverPrendas(1);

        System.out.println("Prendas " + prendas2);
    }
}