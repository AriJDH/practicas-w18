import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Creamos las prendas
        Prenda prenda1 = new Prenda("marca1", "modelo1");
        Prenda prenda2 = new Prenda("marca2", "modelo2");
        Prenda prenda3 = new Prenda("marca3", "modelo3");
        Prenda prenda4 = new Prenda("marca4", "modelo4");

        // Creamos el GuardaRopas
        GuardaRopa guardaRopa = new GuardaRopa();

        // Armamos la lista de prendas
        List<Prenda> listaPrendas = Arrays.asList(prenda1,prenda2);
        List<Prenda> listaPrendas2 = Arrays.asList(prenda3);

        // Guardamos las prendas
        System.out.println("------------------ Guardado de prendas ------------------");
        Integer claveCasillero = guardaRopa.guardarPrendas(listaPrendas);
        Integer claveCasillero2 =  guardaRopa.guardarPrendas(listaPrendas2);

        System.out.println("------------------ Devolver prendas ------------------");
        // Consultamos las prendas guardadas antes
        guardaRopa.devolverPrendas(claveCasillero);
        guardaRopa.devolverPrendas(claveCasillero2);

        System.out.println("------------------ Mostrar prendas ------------------");
        guardaRopa.mostrarPrendas();
    }
}