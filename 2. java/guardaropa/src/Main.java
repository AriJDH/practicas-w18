
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // _______________ Se crea una lista 1 ______________
        List<Prenda> listaPrendas1 = new ArrayList<>();
        listaPrendas1.add(new Prenda("Gucci", "2022"));
        listaPrendas1.add(new Prenda("Calvin Klein", "2000"));

        // ________________ Se guarda la lista 1 en el guarda ropa __________
        GuardaRopa guardaRopa = new GuardaRopa();
        System.out.println("Armario " + guardaRopa.guardarRopa(listaPrendas1));

        // _______________ Se crea una lista 2 ______________
        List<Prenda> listaPrendas2 = new ArrayList<>();
        listaPrendas2.add(new Prenda("Adidas", "2021"));

        // ________________ Se guarda la lista 2 en el guarda ropa __________
        guardaRopa.guardarRopa(listaPrendas2);

        guardaRopa.consultarRopa(1);
        guardaRopa.consultarRopa(2);

        System.out.println("La prenda devuelta es: " + guardaRopa.devolverPrendas(2));

    }
}
