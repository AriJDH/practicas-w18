package EjercicioSeriesNumericas.Clases;

public abstract class Prototipo <T> {
    public abstract int devolverSiguiente();
    public abstract void reiniciar();
    public abstract void primerValor(T valor);
}
