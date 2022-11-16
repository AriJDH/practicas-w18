package EjercicioSeriesNumericas.Clases;

public class Serie2 extends Prototipo{
     int valor;
     final int valor2= 2;

    @Override
    public int devolverSiguiente() {
        int siguiente= valor+valor2;
        valor= siguiente;
        return siguiente;
    }

    @Override
    public void reiniciar() {
        primerValor(0);
    }

    @Override
    public void primerValor(Object valor) {
        this.valor= (Integer) valor;

    }
}
