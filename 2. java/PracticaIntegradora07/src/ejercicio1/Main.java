package ejercicio1;

import ejercicio1.model.Prototipo;
import ejercicio1.model.Serie2;
import ejercicio1.model.Serie3;

public class Main {

    public static void main(String[] args) {

        Prototipo<Double> serie = new Serie3();

        System.out.println(serie.getValorInicial());
        serie.setValorInicial(2D);
        System.out.println(serie.getValorInicial());

        System.out.println(serie.getSiguienteValor());
        System.out.println(serie.getSiguienteValor());
        System.out.println(serie.getSiguienteValor());

        System.out.println(serie.getSiguienteValor());

        serie.setValorInicial(4D);

        System.out.println(serie.getValor());

        System.out.println(serie.getSiguienteValor());
        System.out.println(serie.getSiguienteValor());

        System.out.println(serie.getValorInicial());

        serie.reiniciarSerie();

        System.out.println(serie.getValor());


    }

}
