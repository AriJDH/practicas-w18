package EjercicioSeriesNumericas.Clases;

public class Serie3 extends Prototipo{
    int valor;
    final int valor2=3;

    @Override
    public int devolverSiguiente() {
        int siguiente= valor+valor2;
        valor= siguiente;
        return siguiente;
    }

    @Override
    public void reiniciar() {
        valor= 0;
    }

    @Override
    public void primerValor(Object valor) {
        this.valor= (Integer) valor;
    }
}
