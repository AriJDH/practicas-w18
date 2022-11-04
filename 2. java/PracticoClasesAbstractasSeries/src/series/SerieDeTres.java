package series;

public class SerieDeTres extends Serie{
    private static final int incremento = 3;

    public SerieDeTres(Number valorinicial) {
        super(valorinicial);
    }

    @Override
    public Number siguienteValor() {
        setValorActual(getValorActual().doubleValue()+incremento);
        System.out.println(getValorActual().doubleValue());
        return getValorActual();
    }
}
