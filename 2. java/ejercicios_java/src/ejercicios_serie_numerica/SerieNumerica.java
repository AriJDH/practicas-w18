package ejercicios_serie_numerica;

public class SerieNumerica extends Prototipo {

    @Override
    public Integer devolverNumeroSiguiente() {
        setNumeroGenerico(getNumeroGenerico() + 2);
        return getNumeroGenerico();
    }

    @Override
    public void reiniciarSerie() {
        setNumeroGenerico(0);
    }

    @Override
    public void establecerValorInicial(Integer numeroInicial) {
        setNumeroGenerico(numeroInicial);
        setNumeroBase(numeroInicial);
    }
}
