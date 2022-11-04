package ejercicios_serie_numerica;

public class Main {

    public static void main(String[] args) {

        SerieNumerica serieNumericaPar = new SerieNumerica();

        serieNumericaPar.establecerValorInicial(2);

        SerieNumerica serieNumericaImpar = new SerieNumerica();

        serieNumericaImpar.establecerValorInicial(1);

        SerieNumerica serieNumericaMultiplo3 = new SerieNumerica();

        serieNumericaMultiplo3.establecerValorInicial(3);

        System.out.println("NUMEROS PAR");
        for (int i = 0; i < 4; i++) {
            Integer numeroSiguiente = serieNumericaPar.devolverNumeroSiguiente();
            System.out.println(numeroSiguiente);
        }

        System.out.println("NUMEROS IMPAR");
        for (int i = 0; i < 4; i++) {
            Integer numeroSiguiente = serieNumericaImpar.devolverNumeroSiguiente();

            System.out.println(numeroSiguiente);
        }

        System.out.println("NUMEROS MULTIPLO 3");
        for (int i = 0; i < 4; i++) {
            Integer numeroSiguiente = serieNumericaMultiplo3.devolverNumeroSiguiente();

            System.out.println(numeroSiguiente);
        }
    }
}
