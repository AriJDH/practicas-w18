public class SerieDe3 extends Prototipo {
    public SerieDe3(int valorInicial) {
        super(valorInicial);
    }

    @Override
    public int siguiente() {
        setValorActual(super.getValorActual()+3);
        return super.getValorActual();
    }
}
