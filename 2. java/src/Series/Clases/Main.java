package Series.Clases;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        SerieUno serieUno = new SerieUno();
        serieUno.setInitialValue(1);
        Stream.of(serieUno.getNextValue()).forEach(System.out::println);
        Stream.of(serieUno.getNextValue()).forEach(System.out::println);
        Stream.of(serieUno.getNextValue()).forEach(System.out::println);
        Stream.of(serieUno.getNextValue()).forEach(System.out::println);
        serieUno.setInitialValue(100);
        Stream.of(serieUno.getNextValue()).forEach(System.out::println);
        Stream.of(serieUno.getNextValue()).forEach(System.out::println);
        Stream.of(serieUno.getNextValue()).forEach(System.out::println);
        Stream.of(serieUno.getNextValue()).forEach(System.out::println);
        serieUno.setValueCero();
    }
}
