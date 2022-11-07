public class PrototipoTres extends Prototipo<Integer> {

    public PrototipoTres() {
    }

    public PrototipoTres(Integer initialValue, Integer value, Integer a) {
        super(initialValue, value, a);
    }

    @Override
    public Integer nextValue(Integer a) {
        value = value + a;
        return value ;
    }

    @Override
    public void setValue() {
        value = initialValue;
    }

    @Override
    public void setInitialValue(Integer newInitialValue) {
        initialValue = newInitialValue;
    }

    @Override
    public void setA(Integer newA) {
        a = newA;
    }
}
