package ejercicios_serie_numerica;

public class SerieNumericaMultiplo3 extends Prototipo {
    @Override
    public Integer devolverNumeroSiguiente() {
        setNumeroGenerico(getNumeroGenerico() + 3);
        return getNumeroGenerico();
    }

    @Override
    public void reiniciarSerie() {
        setNumeroGenerico(1);
    }

    @Override
    public void establecerValorInicial(Integer numeroInicial) {
        setNumeroGenerico(numeroInicial);
    }
}
