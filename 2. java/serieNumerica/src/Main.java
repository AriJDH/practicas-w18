public class Main {
    public static void main(String[] args) {

        SerieDoble serieDoble = new SerieDoble();
        SerieTriple serieTriple = new SerieTriple();
        Double newValorTriple;
        Double newValor;

        System.out.println("Iniciando serie de dos");
        serieDoble.valorInicial(2);
        newValor = serieDoble.siguienteValor(serieDoble.getLista().get(serieDoble.getLista().size()-1));
        serieDoble.getLista().add(newValor);
        newValor = serieDoble.siguienteValor(serieDoble.getLista().get(serieDoble.getLista().size()-1));
        serieDoble.getLista().add(newValor);
        newValor = serieDoble.siguienteValor(serieDoble.getLista().get(serieDoble.getLista().size()-1));
        serieDoble.getLista().add(newValor);
        System.out.println(serieDoble.getLista());

        System.out.println("\nReiniciando serie de dos");
        serieDoble.reiniciarSerie();
        System.out.println(serieDoble.getLista());

        System.out.println("\nIniciando serie de tres");
        serieTriple.valorInicial(3);
        newValorTriple = serieTriple.siguienteValor(serieTriple.getLista().get(serieTriple.getLista().size()-1));
        serieTriple.getLista().add(newValorTriple);
        newValorTriple = serieTriple.siguienteValor(serieTriple.getLista().get(serieTriple.getLista().size()-1));
        serieTriple.getLista().add(newValorTriple);
        newValorTriple = serieTriple.siguienteValor(serieTriple.getLista().get(serieTriple.getLista().size()-1));
        serieTriple.getLista().add(newValorTriple);

        System.out.println(serieTriple.getLista());
        System.out.println("\nReiniciando serie de tres");
        serieTriple.reiniciarSerie();
        System.out.println(serieTriple.getLista());

    }
}
