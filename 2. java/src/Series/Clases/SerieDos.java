package Series.Clases;

public class SerieDos extends Prototipo{
    int value = 0;
    int valorSumar = 0;

    @Override
    public String toString() {
        return "SerieDos{" +
                "value=" + value +
                '}';
    }

    @Override
    public int getNextValue() {
        Integer nextValue = this.value + this.valorSumar;
        this.value = nextValue;
        return nextValue;
    }

    @Override
    public void setValueCero() {
        this.value = 0;
    }

    @Override
    public void setInitialValue(Object value) {
        if (this.value == 0) {
            this.value += (Integer) value;
            System.out.println(value);
        }
        this.valorSumar += (Integer) value;
    }
}
