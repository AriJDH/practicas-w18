public class PrototypeOne extends Prototype<Double> {

    public PrototypeOne() {
    }

    public PrototypeOne(Double initialValue, Double value, Double a) {
        super(initialValue, value, a);
    }

    @Override
    public Double nextValue(Double a) {
        value = value + a;
        return value;
    }

    @Override
    public void setValue() {
        value = initialValue;
    }

    @Override
    public void setInitialValue(Double newInitialValue) {
        initialValue = newInitialValue;
    }

    @Override
    public void setA(Double newA) {
        a = newA;
    }



}
