import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Creamos lista de prendas
        List<Prenda> listaDePrendas = new ArrayList<>();


        //Creamos las prendas a guardar
        Prenda buzo = new Prenda("Nike","Truchini");
        Prenda camisa = new Prenda("Adidas","manga corta");

        //Creamos lista de prendas
        List<Prenda> listaDePrendas1 = new ArrayList<>();

        //Creamos las prendas a guardar
        Prenda pantalon = new Prenda("Nike","cortos");
        Prenda pollera = new Prenda("Reebok", "larga");

        //Creamos lista de prendas
        List<Prenda> listaDePrendas2 = new ArrayList<>();

        //Creamos las prendas a guardar
        Prenda medias = new Prenda("Gap","abrigadas");
        Prenda campera = new Prenda("Puma", "calurosa");

        //Almacenamos las prendas en las listas correspondientes
        listaDePrendas.add(buzo);
        listaDePrendas.add(camisa);

        listaDePrendas1.add(pantalon);
        listaDePrendas1.add(pollera);

        listaDePrendas2.add(medias);
        listaDePrendas2.add(campera);

        //Creo el guarda ropa
        GuardaRopa guardaRopa = new GuardaRopa();

        //Guardo las prendas correspondientes en, el casillero
        guardaRopa.guardaPrendas(listaDePrendas);
        guardaRopa.guardaPrendas(listaDePrendas1);
        guardaRopa.guardaPrendas(listaDePrendas2);

        //Solicito información respecto a un casillero específico
        guardaRopa.devolverPrendas(2).stream().forEach(System.out::println);



    }
}