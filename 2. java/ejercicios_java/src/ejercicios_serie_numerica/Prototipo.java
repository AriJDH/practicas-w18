package ejercicios_serie_numerica;

public abstract class Prototipo <T extends Integer> {

    private T numeroGenerico;

    private T numeroBase;

    public abstract T devolverNumeroSiguiente();

    public abstract void reiniciarSerie();

    public abstract void establecerValorInicial(T numeroInicial);

    public T getNumeroGenerico() {
        return numeroGenerico;
    }

    public void setNumeroGenerico(T numeroGenerico) {
        this.numeroGenerico = numeroGenerico;
    }

    public T getNumeroBase() {
        return numeroBase;
    }

    public void setNumeroBase(T numeroBase) {
        this.numeroBase = numeroBase;
    }
}
