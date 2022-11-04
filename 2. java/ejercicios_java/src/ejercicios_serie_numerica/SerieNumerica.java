package ejercicios_serie_numerica;

public class SerieNumerica extends Prototipo {

    @Override
    public Integer devolverNumeroSiguiente() {

        Integer numero = getNumeroGenerico();

        if (getNumeroBase().equals(1)) {
            setNumeroGenerico(numero + 2);
        } else {
            setNumeroGenerico(numero + getNumeroBase());
        }

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
