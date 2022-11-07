public class SerieDe2 extends Prototipo {
    public SerieDe2(int valorInicial) {
        super(valorInicial);
    }

    @Override
    public int siguiente() {
        setValorActual(super.getValorActual()+2);
        return super.getValorActual();
    }
}
