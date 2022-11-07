public class PrototypeTwo extends Prototype<Integer> {

    public PrototypeTwo() {
    }

    public PrototypeTwo(Integer initialValue, Integer value, Integer a) {
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
