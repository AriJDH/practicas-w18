import series.SerieDeDos;
import series.SerieDeTres;

public class Main {
    public static void main(String[] args) {
        SerieDeDos prueba = new SerieDeDos(Integer.valueOf(5));
        prueba.siguienteValor();
        prueba.siguienteValor();
        prueba.siguienteValor();
        prueba.siguienteValor();

        prueba.configurarValorInicial(Integer.valueOf(1));
        prueba.reiniciarSerie();

        prueba.siguienteValor();
        prueba.siguienteValor();
        prueba.siguienteValor();

        SerieDeTres prueba3 = new SerieDeTres(Double.valueOf(5.5));

        prueba3.siguienteValor();
        prueba3.siguienteValor();
        prueba3.siguienteValor();
        prueba3.siguienteValor();

        prueba3.configurarValorInicial(Integer.valueOf(11));
        prueba3.reiniciarSerie();

        prueba3.siguienteValor();
        prueba3.siguienteValor();
        prueba3.siguienteValor();
    }
}