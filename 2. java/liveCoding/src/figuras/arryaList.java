package figuras;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class arryaList {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        List<String> nombres1 = new ArrayList<>();
        List<List<String>> listado = new ArrayList<>();
        nombres.add(0, "Pame");
        nombres.add(1,"Miguel");
        nombres1.add(0,"Yani");
        nombres1.add(0, "Hola");

        listado.add(0, nombres);
        listado.add(1, nombres1);

        List<String> lista= new ArrayList<>();


        //for( List<String> nom : listado) {
        //    nom.forEach( element -> lista.add(element));
        //}

        //lista.forEach( element -> System.out.println(element));

        listado.stream().forEach(element -> element.forEach(nom -> lista.add(nom.toString())));
        lista.forEach(element -> System.out.println(element));
    }

}
