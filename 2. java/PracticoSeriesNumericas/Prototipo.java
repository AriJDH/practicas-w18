package SeriesNumericas;

public abstract class Prototipo<T>  {

    public abstract void valorInicial(T valor);
    public abstract int siguienteValor();
    public abstract void reiniciarSerie();
}
