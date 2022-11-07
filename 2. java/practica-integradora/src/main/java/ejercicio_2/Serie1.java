package ejercicio_2;

public class Serie1 extends Prototipo{

    public Serie1(int valorInicial) {
        super(valorInicial);
    }

    @Override
    public int devolverValor() {
        setValorInicial(getValorInicial()+3);
        return getValorInicial();
    }

    @Override
    public void reiniciarSerie() {
        setValorInicial(0);
    }

    @Override
    public void nuevoValorInicial(int valor) {
        setValorInicial(valor);
    }
}
