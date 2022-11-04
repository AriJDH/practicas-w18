package SeriesNumericas;

public class Serie2 extends Prototipo{
    int valor;
    final int valor2 = 2;

    @Override
    public void valorInicial(Object valor) {
        this.valor = (Integer) valor;
    }

    @Override
    public int siguienteValor() {
        int sigValor = valor+valor2;
        valor = sigValor;
        return sigValor;
    }

    @Override
    public void reiniciarSerie() {
        this.valor = 0;
    }
}
