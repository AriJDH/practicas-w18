package series;

public class SerieDeDos extends Serie{
    private static final int incremento = 2;

    public SerieDeDos(Number valorinicial) {
        super(valorinicial);
    }

    @Override
    public Number siguienteValor() {
        setValorActual(getValorActual().doubleValue()+incremento);
        System.out.println(getValorActual().doubleValue());
        return getValorActual();
    }
}
